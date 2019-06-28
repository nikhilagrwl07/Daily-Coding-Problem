/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {

        // "23" --> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        // "abc" + "def" --> ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        String[] lookup = new String[10];
        lookup[2] = "abc";
        lookup[3] = "def";
        lookup[4] = "ghi";
        lookup[5] = "jkl";
        lookup[6] = "mno";
        lookup[7] = "pqrs";
        lookup[8] = "tuv";
        lookup[9] = "wxyz";

        String[] input = new String[digits.length()];
        int index = 0;
        for (char c : digits.toCharArray()) {
            input[index++] = lookup[Character.getNumericValue(c)];
        }

        ArrayList<String> result = new ArrayList<>();
        letterCombinationsUtil(input, new int[input.length], result);
        return result;
    }


    public static void letterCombinationsUtil(String[] input, int[] indexes, List<String> result) {

        // Collecting formed string by iterating over given indexes
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indexes.length; i++) {
            int currentIndex = indexes[i];
            if (currentIndex < input[i].length()) {
                String currentString = input[i];
                sb.append(currentString.charAt(currentIndex));
            }
            else{
                return;
            }
        }

       // Checking edge condition
        String ans = sb.toString();
        if (ans.isEmpty())
            return;
        else
        {
            if(!result.contains(ans))
                result.add(ans);
        }

        //Recursion
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = indexes[i] + 1;

            letterCombinationsUtil(input, indexes, result);

            // Revert back
            indexes[i] = indexes[i] - 1;
        }
    }
}