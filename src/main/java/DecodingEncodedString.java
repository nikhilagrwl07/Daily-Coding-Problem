package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
*/
public class DecodingEncodedString {

    private static Map<Integer, Character> intToCharMapping = new HashMap<>();

    public static void main(String[] args) {
        intToCharMapping = populateMap();
        char[] result = new char[256];


        decode(1919, 0, result, new HashSet<>());

    }

    private static void decode(int message, int currentIndex, char[] result, Set<String> set) {

        if (message <= 0) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i <= currentIndex - 1; i++)
                stringBuilder.insert(0, result[i]);

            if(!set.contains(stringBuilder.toString())){
                System.out.println(stringBuilder.toString());
                set.add(stringBuilder.toString());
            }
            return;
        }

        for (int i = 1; i <= 2; i++) {
            int divisor = (int) (Math.pow(10, i));

            int modulo = message % divisor;
            int remaining = message / divisor;

            Character moduloMapping = intToCharMapping.get(modulo);

            if(moduloMapping!=null)
            {
                result[currentIndex] = moduloMapping;
                decode(remaining, currentIndex + 1, result, set);
            }
        }
    }

    private static Map<Integer, Character> populateMap() {
        Map<Integer, Character> intToCharMapping = new HashMap<>();
        intToCharMapping.put(1, 'a');
        intToCharMapping.put(2, 'b');
        intToCharMapping.put(3, 'c');
        intToCharMapping.put(4, 'd');
        intToCharMapping.put(5, 'e');
        intToCharMapping.put(6, 'f');
        intToCharMapping.put(7, 'g');
        intToCharMapping.put(8, 'h');
        intToCharMapping.put(9, 'i');
        intToCharMapping.put(10, 'j');
        intToCharMapping.put(11, 'k');
        intToCharMapping.put(12, 'l');
        intToCharMapping.put(13, 'm');
        intToCharMapping.put(14, 'n');
        intToCharMapping.put(15, 'o');
        intToCharMapping.put(16, 'p');
        intToCharMapping.put(17, 'q');
        intToCharMapping.put(18, 'r');
        intToCharMapping.put(19, 's');
        intToCharMapping.put(20, 't');
        intToCharMapping.put(21, 'u');
        intToCharMapping.put(22, 'v');
        intToCharMapping.put(23, 'w');
        intToCharMapping.put(24, 'x');
        intToCharMapping.put(25, 'y');
        intToCharMapping.put(26, 'z');
        return intToCharMapping;
    }

}
