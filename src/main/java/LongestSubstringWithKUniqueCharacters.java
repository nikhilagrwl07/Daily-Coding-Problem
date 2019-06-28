/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {

        String input = "aabbccccc";
//        String input = "aaabbbaaabbbc";
        int k = 3;

        System.out.println(longestSubstringWithKUniqueCharacters(input, k));
    }

    private static String longestSubstringWithKUniqueCharacters(String input, int k) {

        if (input == null || input.isEmpty() || k <= 0 || k > input.length()) {
            return null;
        }

        char[] c = input.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int s = 0, e = 1;

        m.put(c[s], 1);

        String longestSubstringWithKUniqueCharacters = "";

        while (e <= input.length() - 1) {

            if (m.keySet().size() == k) { // caution case

                if (m.get(c[e]) == null) { // new key arrived

                    if (longestSubstringWithKUniqueCharacters.length() < (e - s)) {
                        longestSubstringWithKUniqueCharacters = input.substring(s, e);
                    }

                    while (s < e) {
                        if (m.get(c[s]) == 1) {
                            m.remove(c[s]);
                        } else {
                            m.put(c[s], m.get(c[s]) - 1);
                        }

                        s++;
                        if (m.keySet().size() < k) {
                            m.put(c[e], 1);
                            if (longestSubstringWithKUniqueCharacters.length() < (e - s + 1)) {
                                longestSubstringWithKUniqueCharacters = input.substring(s, e + 1);
                            }
                            break;
                        }
                    }
                } else // repeating key has arrived
                {
                    m.put(c[e], m.get(c[e]) + 1);

                    if (longestSubstringWithKUniqueCharacters.length() < (e - s + 1)) {
                        longestSubstringWithKUniqueCharacters = input.substring(s, e + 1);
                    }
                }

            } else         // simply add the occurence
            {
                if (m.get(c[e]) == null) {
                    m.put(c[e], 1);
                } else {
                    m.put(c[e], m.get(c[e]) + 1);
                }
                if (longestSubstringWithKUniqueCharacters.length() < (e - s + 1)) {
                    longestSubstringWithKUniqueCharacters = input.substring(s, e + 1);
                }
            }
            e++;
        }

        return longestSubstringWithKUniqueCharacters;
    }

}
