package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class LongestSubStringWithKDistinctCharacters {

    public static void main(String[] args) {
        int k = 2;
        String s = "abcba";
        System.out.println(longestSubStringWithKDistinctCharacters(k, s.toCharArray()));

        System.out.println(longestSubStringWithKDistinctCharactersSlidingApproach(k, s.toCharArray()));
    }

//  Time Complexity - O(n)
//  Space Complexity - O(number of distinct characters)  ~O(1)
    private static String longestSubStringWithKDistinctCharactersSlidingApproach(int k, char[] input) {
        int start = 0;
        int end = start + k;
        String longestMax = "";
        StringBuilder longestSubString = new StringBuilder();

        // Populate Map
        Map<Character, Integer> freqMap = new HashMap<>();
        while (start < end && end <= input.length - 1) {

            char key = input[start];
            if (freqMap.containsKey(key)) {
                Integer count = freqMap.get(key);
                freqMap.put(key, count + 1);
            } else {
                freqMap.put(key, 1);
            }
            longestSubString.append(key);
            start++;
        }



        // Sliding Logic
        while (start<=input.length-1){
             int currentCount = getTotalDistinctCount(freqMap);
             char key = input[start];

             if(currentCount < k){
                 longestSubString.append(key);

                 if (freqMap.containsKey(key)) {
                     Integer count = freqMap.get(key);
                     freqMap.put(key, count + 1);
                 } else {
                     freqMap.put(key, 1);
                 }
            }
             else
             {
                 longestSubString.append(key);
                 int count;

                 if (freqMap.containsKey(key)) {
                     count = freqMap.get(key);
                     freqMap.put(key, count + 1);

                     if(longestMax.length() < longestSubString.length()){
                         longestMax = longestSubString.toString();
                     }

                     start++;
                     continue;
                 } else {
                     freqMap.put(key, 1);
                 }

                 char firstElement = longestSubString.charAt(0);
                 longestSubString.deleteCharAt(0);

                 count = freqMap.get(firstElement);
                 if(count==1)
                 {
                     freqMap.remove(firstElement);
                 }
                 else
                 {
                     freqMap.put(key, count - 1);
                 }


             }
            start++;

        }
        return longestMax;

    }

    private static int getTotalDistinctCount(Map<Character, Integer> freqMap){

        return freqMap.keySet().size();

    }


    //    Time Complexity - O(n2)
//     Space Complexity - O(1)
    private static String longestSubStringWithKDistinctCharacters(int k, char[] input) {
        if (input == null || input.length < k)
            return null;
        String longestSubString = "";

        for (int i = 0; i < input.length - 1; i++) {

            int start = i;

            int distinctCount = 1;
            Set<Character> set = new HashSet<>();
            set.add(input[start]);
            int j = start + 1;
            for (; j <= input.length - 1; j++) {
                char currentChar = input[j];
                if (distinctCount < k) {

                    // Case 1 - Unique Element in set
                    if (!set.contains(currentChar)) {
                        set.add(currentChar);
                        distinctCount++;
                    } else // Case 2 - Element already existing in set
                    {
                        continue;
                    }
                } else if (distinctCount == k) {
                    if (set.contains(currentChar)) {
                        continue;
                    } else {
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();

            while (start < j) {
                sb.append(input[start]);
                start++;
            }
            String substring = sb.toString();

            if (longestSubString.length() < substring.length()) {
                longestSubString = substring;
            }
        }
        return longestSubString;
    }
}
