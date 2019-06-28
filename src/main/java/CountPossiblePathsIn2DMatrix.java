/*
    Problem - Count all possible paths from top left to bottom right of a mXn matrix
              The problem is to count all the possible paths from top left to bottom right of
              a mXn matrix with the constraints that from each cell you can either move only to right or down

    Solution - Dynamic Matrix Approach
    Time Complexity - O(rows * Columns)
    Space Complexity - O(rows * Columns)
 */


package main.java;

public class CountPossiblePathsIn2DMatrix {
    public static void main(String[] args) {
        int rows = 2, columns = 3;

        int uniquePaths = countUniquePaths(rows, columns);
        System.out.println(uniquePaths);
    }

    private static int countUniquePaths(int rows, int columns) {

        int[][] uniquePathCount = new int[rows][columns];


        uniquePathCount[0][0] = 1;

        for (int column = 1; column <= columns - 1; column++) {
            uniquePathCount[0][column] = 1;
        }

        for (int row = 1; row <= rows - 1; row++) {
            uniquePathCount[row][0] = 1;
        }

        for (int row = 1; row <= rows - 1; row++) {
            for (int column = 1; column <= columns - 1; column++) {
                // Case 1 --> Going Left            // Case 2 --> Going Up
                uniquePathCount[row][column] = uniquePathCount[row][column - 1] + uniquePathCount[row - 1][column];

            }

        }

        return uniquePathCount[rows - 1][columns - 1];
    }

}
