/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class WordSearchInMatrix {
    public static void main(String[] args) {
        char[][] board = {

                //                {
                {'a', 'a', 'a'},
                {'a', 'b', 'b'},
                {'a', 'b', 'b'},
                {'b', 'b', 'b'},
                {'b', 'b', 'b'},
                {'a', 'a', 'a'},
                {'b', 'b', 'b'},
                {'a', 'b', 'b'},
                {'a', 'a', 'b'},
                {'a', 'b', 'a'}};
//        }
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};

        String word = "aabaaaabbb";


        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty())
            return false;
        int rows = board.length;
        int columns = board[0].length;

        boolean[][] isVisited = new boolean[rows][columns];

        char[] c = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (dfs(c, 0, i, j, board, isVisited))
                    return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[] c, int currentIndex, int i, int j, char[][] board, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                isVisited[i][j] || c[currentIndex] != board[i][j])
            return false;

        if (currentIndex == c.length - 1)
            return true;


        isVisited[i][j] = true;

        //Right
        boolean result = dfs(c, currentIndex + 1, i, j + 1, board, isVisited) ||

                //Left
                dfs(c, currentIndex + 1, i, j - 1, board, isVisited) ||

                //Up
                dfs(c, currentIndex + 1, i - 1, j, board, isVisited) ||

                //Down
                dfs(c, currentIndex + 1, i + 1, j, board, isVisited);


        isVisited[i][j] = false;
        return result;

    }
}
