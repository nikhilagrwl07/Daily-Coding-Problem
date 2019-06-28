/*
    Problem - You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

    Solution - Backtracking
    Time Complexity -
    Space Complexity -
 */


package main.java;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MinimumNumberOfStepsToReachDestinationIn2DMatrix {

    static final boolean[][] field = {              // False represent tile to walk on
            {FALSE, FALSE, FALSE, FALSE},           // True represent wall on which u can't walk
            {TRUE, TRUE, FALSE, TRUE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    };

    public static void main(String[] args) {

        int[][] solutionPath = new int[4][4];

        int steps = minimumNumberOfStepsFromSourceToDestination(3, 0, 0, 0, Integer.MAX_VALUE, 0, solutionPath);
        printSolution(solutionPath);
        System.out.println(steps);

    }

    private static void printSolution(int[][] solutionPath) {
        for (int i = 0; i < solutionPath.length; i++) {
            for (int j = 0; j < solutionPath[0].length; j++) {
                System.out.print(solutionPath[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int minimumNumberOfStepsFromSourceToDestination(int x1, int y1, int x2, int y2, int minDistance, int currentDistance, int[][] solutionPath) {

        if (x1 == x2 && y1 == y2) // destination reached
        {
            solutionPath[x1][y1] = 1;
            return Math.min(minDistance, currentDistance);
        }


        // consider x1 and y1 as part of solution by marking it to 1
        solutionPath[x1][y1] = 1;

        // Go Left
        if (isValid(solutionPath, x1, y1 - 1) && isPossibleAndVisited(solutionPath, x1, y1 - 1)) {
            minDistance = minimumNumberOfStepsFromSourceToDestination(x1, y1 - 1, x2, y2, minDistance, currentDistance + 1, solutionPath);
        }

        // Go up
        if (isValid(solutionPath, x1 - 1, y1) && isPossibleAndVisited(solutionPath, x1 - 1, y1)) {
            minDistance = minimumNumberOfStepsFromSourceToDestination(x1 - 1, y1, x2, y2, minDistance, currentDistance + 1, solutionPath);
        }

        // Go Right
        if (isValid(solutionPath, x1, y1 + 1) && isPossibleAndVisited(solutionPath, x1, y1 + 1)) {
            minDistance = minimumNumberOfStepsFromSourceToDestination(x1, y1 + 1, x2, y2, minDistance, currentDistance + 1, solutionPath);
        }

        // Go Down
        if (isValid(solutionPath, x1 + 1, y1) && isPossibleAndVisited(solutionPath, x1 + 1, y1)) {
            minDistance = minimumNumberOfStepsFromSourceToDestination(x1 + 1, y1, x2, y2, minDistance, currentDistance + 1, solutionPath);
        }

        solutionPath[x1][y1] = 0;

        return minDistance;
    }

    private static boolean isValid(int[][] m, int x, int y) {
        return (x >= 0 && x <= m.length - 1) && (y >= 0 && y <= m[0].length - 1);

    }

    private static boolean isPossibleAndVisited(int[][] solution, int x, int y) {
        return !field[x][y] && solution[x][y] == 0;

    }
}
