/*
    Problem -Given a m * n matrix, if an element is 0, set its entire row and column to 0.
                Do it in place.

    Solution -
 */


package main.java;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {

        int[][] m = {
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };

        System.out.println(Arrays.deepToString(m));
        setZeros(m);
        System.out.println(Arrays.deepToString(m));
    }

//    Time Complexity -O(row * column)
//    Space Complexity - O(1)
    static void setZerosSpaceOptimized(int[][] matrix) {

        boolean firstRow = false, firstColumn = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                // check for presenece of 0 in first row
                if (i == 0 && !firstRow && matrix[i][j] == 0) {
                    firstRow = true;
                }

                // check for presenece of 0 in first col
                if (j == 0 && !firstColumn && matrix[i][j] == 0) {
                    firstColumn = true;
                }

                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // marking row in first row as 0
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][i] = 0;
            }
        }

        if(firstRow){
            for(int j = 0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }

        if(firstColumn){
            for(int i = 0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }

    }

    //    Time Complexity - O(row * column)
//    Space Complexity -O(row +column)
    static void setZeros(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[] rowArray = new boolean[rows];
        boolean[] columnArray = new boolean[columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    rowArray[i] = true;
                    columnArray[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rowArray[i] && columnArray[j]) {

                    setZeros(matrix, i, j, true);
                    setZeros(matrix, i, j, false);

                }
            }
        }

    }

    private static void setZeros(int[][] m, int row, int column, boolean setRow) {

        if (setRow) {
            for (int j = 0; j <= m[0].length - 1; j++) {
                m[row][j] = 0;
            }
        } else {
            for (int i = 0; i <= m.length - 1; i++) {
                m[i][column] = 0;
            }
        }

    }
}
