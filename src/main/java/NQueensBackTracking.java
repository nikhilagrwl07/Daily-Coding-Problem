/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.Arrays;

public class NQueensBackTracking {
    public static void main(String[] args) {
        int numberOfQueens = 4;
        int boardDimension = 4;

        int[][] board = new int[boardDimension][boardDimension];
        System.out.println(Arrays.deepToString(board));
        NQueensPlacement(board, 0);
        System.out.println(Arrays.deepToString(board));
    }

    private static boolean NQueensPlacement(int[][] board, int column) {
        if (column == board[0].length)
            return true;

        for (int r = 0; r < board.length; r++) {
            if (isSafe(board, r, column)) {
                board[r][column] = 1;
                if (NQueensPlacement(board, column + 1)) {
                    return true;
                }
                board[r][column] = 0; // Backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int column) {
        if (row >= board.length || column >= board[0].length) {
            return false;
        }

        // Upper left Diagonal
        for (int r = row, c = column; (r >= 0 && c >= 0); r--, c--) {
            if (board[r][c] == 1)
                return false;
        }

        // Middle left straight
        for (int c = column; (c >= 0); c--) {
            if (board[row][c] == 1)
                return false;
        }

        // Lower left Diagonal
        for (int r = row, c = column; (r <= (board.length - 1) && c >= 0); r++, c--) {
            if (board[r][c] == 1)
                return false;
        }

        return true;
    }
}
