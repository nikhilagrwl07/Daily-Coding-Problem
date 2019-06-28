/*
    Problem - You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

For example, given the following board:

[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

    Solution -  BFS
    Time Complexity - O(N*M) - All nodes are visited once
    Space Complexity - O(N*M) - isvisited boolean matrix of size N*M
 */


package main.java;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MinimumNumberOfStepsToReachDestinationIn2DMatrixUsingBFS {

    static final boolean[][] field = {              // False represent tile to walk on
            {FALSE, FALSE, FALSE, FALSE},           // True represent wall on which u can't walk
            {TRUE, TRUE, FALSE, TRUE},
            {FALSE, FALSE, FALSE, FALSE},
            {FALSE, FALSE, FALSE, FALSE}
    };

    public static void main(String[] args) {

        int steps = minimumNumberOfStepsToReachDestinationIn2DMatrixUsingBFS(3, 0, 0, 3, 4);
//        printSolution(solutionPath);
        System.out.println(steps);
    }

    // BFS --> Queue
    private static int minimumNumberOfStepsToReachDestinationIn2DMatrixUsingBFS(
            int srcX, int srcY, int destX, int destY, int total) {
        boolean[][] isVisited = new boolean[4][4];
        Queue<Point> nearestNodes = new LinkedList<>();

        nearestNodes.add(new Point(srcX, srcY, 0));

        isVisited[srcX][srcY] = true;

        while (!nearestNodes.isEmpty()) {
            Point currentNode = nearestNodes.remove();
            if (currentNode.getX() == destX && currentNode.getY() == destY) {
                return currentNode.getDistance();
            }
            int x = currentNode.getX();
            int y = currentNode.getY();

            // Up
            if(isValid(total, x-1, y) && isPossibleAndUnvisited(isVisited,x-1, y )){
                nearestNodes.add(new Point(x-1, y, currentNode.getDistance()+1));
                isVisited[x-1][y] = true;
            }

            //Down
            if(isValid(total, x+1, y) && isPossibleAndUnvisited(isVisited,x+1, y )){
                nearestNodes.add(new Point(x+1, y, currentNode.getDistance()+1));
                isVisited[x+1][y] = true;
            }

            //Right
            if(isValid(total, x, y+1) && isPossibleAndUnvisited(isVisited,x, y+1)){
                nearestNodes.add(new Point(x, y+1, currentNode.getDistance()+1));
                isVisited[x][y+1] = true;
            }

            //Left
            if(isValid(total, x, y-1) && isPossibleAndUnvisited(isVisited,x, y-1)){
                nearestNodes.add(new Point(x, y-1, currentNode.getDistance()+1));
                isVisited[x][y-1] = true;
            }

        }
        return -1;

    }

    private static boolean isValid(int total, int x, int y) {
        return (x >= 0 && x < total) && (y >= 0 && y < total);

    }

    private static boolean isPossibleAndUnvisited(boolean[][] solution, int x, int y) {
        return !field[x][y] && !solution[x][y];

    }
}

class Point {
    private int x;
    private int y;
    private int distance;

    public Point(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }
}
