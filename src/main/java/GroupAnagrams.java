/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] input = {"eat"};

        System.out.println(groupAnagrams(input));
    }

    public static List<List<String>> groupAnagrams(String[] input) {
        if (input == null || input.length == 0)
            return null;

        List<List<String>> result = new ArrayList<>();

//        if (input.length == 1) {
//            result.add(new ArrayList<String>() {{
//                add(input[0]);
//            }});
//            return result;
//        }


        Map<String, List<String>> m = new HashMap<>();

        for (String s : input) {
            String sortedString = countingSort(s);

            if (m.get(sortedString) == null) { // first time addition
                List<String> l = new ArrayList<>();
                l.add(s);
                m.put(sortedString, l);
            } else {
                List<String> l = m.get(sortedString);
                l.add(s);
                m.put(sortedString, l);
            }
        }
        result.addAll(m.values());

        return result;
    }


    public static String countingSort(String input) {
        int[] arr = new int[26];

        for (char c : input.toCharArray()) {
            if (arr[c - 'a'] == 0) {
                arr[c - 'a'] = 1;
            } else {
                arr[c - 'a'] += 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {

            while (arr[i] > 0) {
                char c = (char) (i + 'a');
                sb.append(c);
                arr[i] = arr[i] - 1;
            }
        }
        return sb.toString();

    }
}
