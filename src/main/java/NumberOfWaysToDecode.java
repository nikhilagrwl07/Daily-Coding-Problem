/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfWaysToDecode {
    public static void main(String[] args) {
//        String input = "226";
//        String input = "1";
//        String input = "01";
//        String input = "10";
//        String input = "12";
        String input = "1029";
//        String input = "101";
//        String input = "111";
//        String input = "6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155";


        int numberOfWays = numberOfPossibleDecoding(input.toCharArray());

        System.out.println(numberOfWays);
    }


    public static int numberOfPossibleDecoding(char[] c) {
        if (c[0] == '0') {
            return 0;
        }

        Map<Integer, String> m = new HashMap<>();
        m.put(1, "A");
        m.put(2, "B");
        m.put(3, "C");
        m.put(4, "D");
        m.put(5, "E");
        m.put(6, "F");
        m.put(7, "G");
        m.put(8, "H");
        m.put(9, "I");
        m.put(10, "J");
        m.put(11, "K");
        m.put(12, "L");
        m.put(13, "M");
        m.put(14, "N");
        m.put(15, "O");
        m.put(16, "P");
        m.put(17, "Q");
        m.put(18, "R");
        m.put(19, "S");
        m.put(20, "T");
        m.put(21, "U");
        m.put(22, "V");
        m.put(23, "W");
        m.put(24, "X");
        m.put(25, "Y");
        m.put(26, "Z");


        return numberOfPossibleDecodingUtil(c, 0, m);
    }

    public static int numberOfPossibleDecodingUtil(char[] c, int index, Map<Integer, String> m) {

        if (index >= c.length)
            return 0;

        Integer integer = Character.getNumericValue(c[index]);
        int result1 = 0;
        int result2 = 0;

        if (m.get(integer) != null) {
            result1 = 1 + numberOfPossibleDecodingUtil(c, index + 1, m);
        } else
            return 0;

        if (index + 1 >= c.length)
            return result1;

        integer = integer * 10 + Character.getNumericValue(c[index + 1]);

        if (m.get(integer) != null) {
            result2 = 1 + numberOfPossibleDecodingUtil(c, index + 2, m);
        } else
            return result1;

        return result1 + result2;
    }

    // A Dynamic Programming based
// function to count decodings
    static int countDecodingDP(char digits[],
                               int n) {
        // A table to store results of subproblems
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

}
