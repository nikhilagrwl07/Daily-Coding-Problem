/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.Map;

public class CheckTwoStringsAreAnagrams {

    public static void main(String[] args) {

        String s1 = "Nikhil";
        String s2 = "hilNik";

        System.out.println(isAnagram(s1, s2));
    }

    // small characters
    private static boolean isAnagram(String s1, String s2) {

        // base case
        if (s1 == null || s2 == null || Math.abs(s1.length() - s2.length()) > 0)
            return false;

        Map<Character, Integer> m = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }

        // Traversing over second string
        for (char c : s2.toCharArray()) {

            Integer freq = m.get(c);
            if (freq == null) {
                return false;
            }
            if (freq == 1) {
                m.remove(c);
            } else {
                m.put(c, m.get(c) - 1);
            }
        }

        return true;
    }
}
