/*
    Problem - Given a string, find the length of the longest substring without repeating characters.
    Solution -
    Time Complexity - O(Length of input String)
    Space Complexity - O()
 */


package main.java;

public class LongestSubStringWithoutRepeatedCharacters {
    public static void main(String[] args) {
        String input = "abcabcbb";
//        String input = "bbbbb";
//        String input = "dvdf";
//        String input = "  ";
//        String input = "aabaab!bb";
//        String input = "au";
        System.out.println(lengthOfLongestSubstring(input));

    }

    // Sliding Window Concept
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        if (s.length() == 1)
            return 1;


        char[] c = s.toCharArray();

        int longestSubString = 1;

//        Notes
//        int[26] for Letters 'a' - 'z' or 'A' - 'Z'
//        int[128] for ASCII
//        int[256] for Extended ASCII

        int[] index = new int[128];

        int start = 0;
        index[c[start]] = start + 1;

        for (int end = 1; end < c.length; end++) {

            if (index[c[end]] != 0) { // duplicate case --> remove from start until end can be added

                while (index[c[end]] != 0 && start < end) {
                    index[c[start]] = 0;
                    start++;
                }
                index[c[end]] = end + 1;


            } else { // unique case
                index[c[end]] = end + 1;

                if ((end - start + 1) > longestSubString) {
                    longestSubString = end - start + 1;
                }
            }
        }
        return longestSubString;

    }
}
