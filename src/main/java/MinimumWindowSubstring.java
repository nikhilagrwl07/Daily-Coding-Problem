/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
//        String text = "ADOBECODEBANC";
//        String pattern = "ABC";

        String text = "aaflslflsldkalskaaa";
        String pattern = "aaa";
        String minWindow = minWindow(pattern, text);
        System.out.println(minWindow);

    }

    // WRONG approach - fix it later
    public static String minWindow(String p, String t) {

        if (p == null || p.isEmpty() || t == null || t.isEmpty())
            return "";

        Map<Character, Integer> m = new HashMap<>();
        for (char c : p.toCharArray()) {
            m.put(c, 0);
        }

        int start = 0, end = 0;
        char[] txt = t.toCharArray();
        for (int i = 0; i < txt.length; i++) {
            if (m.containsKey(txt[i])) {
                start = i;
                end = start + 1;
                m.put(txt[i], m.get(txt[i]) + 1);
                break;
            }
        }
        String minimumWindown = "";
        while (end < txt.length) {

            if (m.containsKey(txt[end])) {
                m.put(txt[end], m.get(txt[end]) + 1);
            }

            if (allFound(m)) {
                int l = end - start + 1;
                if (minimumWindown == "" || minimumWindown.length() > l) {
                    System.out.println("start = " + start + " end = " + end);
                    minimumWindown = t.substring(start, end + 1);
                }
                start = shiftStart(m, start, txt, end);
            }
            end++;
        }
        return minimumWindown;
    }

    private static int shiftStart(Map<Character, Integer> m, int start, char[] txt, int end) {

        if (start > end) {
            return -1;
        }
//        System.out.println("start = "+ start+ " end = " + end);

        if(m.get(txt[start])!=null)
        {
            m.put(txt[start], m.get(txt[start]) - 1);
        }

        start = start + 1;

        for (; start < txt.length && start < end; start++) {
            if (m.get(txt[start]) != null) {
                m.put(txt[start], 1);
                break;
            }
        }
        return start;
    }

    public static boolean allFound(Map<Character, Integer> m) {
        for (Integer i : m.values()) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}
