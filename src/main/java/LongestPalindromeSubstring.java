/*
    Problem - Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
    Solution - Dynamic Programming
 */


package main.java;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
//        String input = "forgeeksskeegfor";
//        String input = "babad";
//        String input = "cbbd";
//        String input = "";
        String input = "NIKHIL";
//        System.out.println(longestPalindromeSubstring(input));
        System.out.println(longestPalindromeSubstringSpaceOptimized(input));

    }

    //    Time Complexity - O(N^2)
//    Space Complexity - O(N^2)
    private static String longestPalindromeSubstring(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty() || input.length() == 1)
            return input;

        boolean[][] lps = new boolean[input.length()][input.length()];
        char[] c = input.toCharArray();
        int longestPalindromeSubstring = 1;
        int start = 0;

        //subString of length of 1 and 2
        for (int i = 0; i < input.length(); i++) {
            lps[i][i] = true;

            if (isSafe(i + 1, c) && c[i] == c[i + 1]) {
                lps[i][i + 1] = true;
                longestPalindromeSubstring = 2;
                start = i;
            }
        }

        int currentLength = 3;


        while (currentLength <= c.length) {
            for (int i = 0; i <= (c.length - 1); i++) {

                int j = i + currentLength - 1;

                if (isSafe(j, c) && c[j] == c[i] && lps[i + 1][j - 1]) {
//                    System.out.println("i = " + i + " j = " + j + " longestPalindromeSubstring = " + longestPalindromeSubstring);
                    lps[i][j] = true;
                    if (longestPalindromeSubstring < (j - i + 1)) {
                        longestPalindromeSubstring = (j - i + 1);
                        start = i;
                    }
                }
            }
            currentLength++;
        }

        return input.substring(start, start + longestPalindromeSubstring);
    }

    private static boolean isSafe(int i, char[] c) {
        return i >= 0 && i <= c.length - 1;
    }

    //    Time Complexity - O(N^2)
    //    Space Complexity - O(1)
    private static String longestPalindromeSubstringSpaceOptimized(String input) {
        if (input == null) {
            return null;
        }

        if (input.isEmpty() || input.length() == 1)
            return input;

        char[] c = input.toCharArray();
        String largestLPS = "";
        for (int i = 1; i < c.length; i++) {

            String lps = "";
            // ODD --> centered at i
            int center = i;
            int left = center - 1;
            int right = center + 1;
            while (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {
                lps = input.substring(left, right + 1);
                left--;
                right++;
            }


            // EVEN --> centered at i , i-1

            int center2 = i;
            int center1 = i - 1;
            left = center1 - 1;
            right = center2 + 1;
            if (c[center1] == c[center2]) {

                if ((center2 - center1 + 1) > lps.length()) {
                    lps = input.substring(center1, center2 + 1);
                }

                while (isSafe(left, c) && isSafe(right, c) && c[left] == c[right]) {

                    if ((right - left + 1) > lps.length()) {
                        lps = input.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }
            }

            if (!lps.isEmpty() && lps.length() > largestLPS.length()) {
                largestLPS = lps;
            }
        }

        if(largestLPS.isEmpty())
        {
            largestLPS = String.valueOf(c[0]);
        }
        return largestLPS;
    }

}
