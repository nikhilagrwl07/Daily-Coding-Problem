/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] input = {"flower", "flow", "flight"};
        String[] input = {"aaa","aa","aaa"};
//        String[] input = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] s) {
        if (s == null || s.length == 0) {
            return "";
        }

        if (s.length == 1) {
            return s[0];
        }

        Map<Integer, Character> m = new HashMap<>();

        String current = s[0];

        for (int i = 0; i < current.length(); i++) {
            m.put(i, current.charAt(i));
        }

        String longest=current;
        for (int i = 1; i < s.length; i++) {
            current = s[i];
            StringBuilder commonPrefix = new StringBuilder();
            for (int j = 0; j < current.length(); j++) {

                Character ch = m.get(j);
                char chCurrent = current.charAt(j);

                if (ch == null || ch != chCurrent) {
                    break;
                } else {
                    commonPrefix.append(ch);
                }
            }

            if(commonPrefix.toString().length() < longest.length()){
                longest = commonPrefix.toString();
            }
        }

        return longest;

    }
}
