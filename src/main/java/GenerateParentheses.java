/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {

        int n = 3;
        List<String> result = generateParenthesis(n);


        System.out.println(result);

    }

    public static List<String> generateParenthesis(int n) {
        if (n <= 0)
            return null;


        List<String> result = new ArrayList<>();
        generateParenthesisUtil(n, 0, 0, new char[2 * n], 0, result);
        return result;

    }

    private static void generateParenthesisUtil(int n, int open, int close, char[] chars,
                                                int index, List<String> result) {

        if (close > open || open > n || close > n)
            return;

        if (close == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < index; i++) {
                sb.append(chars[i]);
            }
            result.add(sb.toString());
            return;
        }

        if (index >= 2 * n) {
            return;
        }

        chars[index] = '(';
        generateParenthesisUtil(n, open + 1, close, chars, index + 1, result);

        chars[index] = ')';
        generateParenthesisUtil(n, open, close + 1, chars, index + 1, result);

    }
}
