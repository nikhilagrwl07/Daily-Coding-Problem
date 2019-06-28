/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(a));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        boolean[] isVisted = new boolean[nums.length];


        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);  // key - number , value - index

        int maxlongestSubarray = 1;

        for (int i = 0; i < nums.length; i++) {

            int currentElement = nums[i];

            if (map.containsKey(currentElement - 1)) {
                continue;
            }

            isVisted[i] = true;
            int longestSubarray = 1;

            while (true) {
                int nextElement = currentElement + 1;
                int previousElement = currentElement - 1;
                if (map.containsKey(nextElement) && !isVisted[map.get(nextElement)]) {
                    longestSubarray++;

                    if (maxlongestSubarray < longestSubarray) {
                        maxlongestSubarray = longestSubarray;
                    }

                    isVisted[map.get(nextElement)] = true;
                    currentElement = nextElement;
                } else if (map.containsKey(previousElement) && !isVisted[map.get(previousElement)]) {
                    longestSubarray++;

                    if (maxlongestSubarray < longestSubarray) {
                        maxlongestSubarray = longestSubarray;
                    }

                    isVisted[map.get(previousElement)] = true;
                    currentElement = previousElement;
                } else {
                    break;
                }

            }
            // reseting visited nodes to false
            isVisted = new boolean[nums.length];

        }

        return maxlongestSubarray;
    }


}
