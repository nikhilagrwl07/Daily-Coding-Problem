package main.java;

public class NestedWeightedSumReversal {
    public static void main(String[] args) {
        String s = "[1,[4]]";

        int totalSum = sumReversal(s);
        System.out.println(totalSum);
    }

    private static int sumReversal(String input) {
        if (input == null || input.isEmpty())
            return 0;

        char[] c = input.toCharArray();
        int currentLevelCount = findTotalDepth(input);
        int totalSum = 0;

        for (int i = 0; i < c.length; i++) {

            char ch = c[i];

            if (ch == '[') {
                currentLevelCount--;
                continue;
            }
            if (ch == ']') {
                currentLevelCount++;
                continue;
            }
            if (ch == ',') {
                continue;
            }
            totalSum += currentLevelCount * (ch - '0');
        }

        return totalSum;
    }


    private static int findTotalDepth(String input) {
        if (input == null || input.isEmpty())
            return 0;

        char[] c = input.toCharArray();
        int currentLevelCount = 0;


        for (int i = 0; i < c.length; i++) {

            char ch = c[i];

            if (ch == '[') {
                currentLevelCount++;
            }
        }
        return currentLevelCount + 1;
    }
}
