package main.java;

public class NestedWeightedSum {
    public static void main(String[] args) {
        String s = "[[1,1],2,[1,1]]";

        int totalSum = sum(s);
        System.out.println(totalSum);
    }

    private static int sum(String input) {
        if (input == null || input.isEmpty())
            return 0;

        char[] c = input.toCharArray();
        int currentLevelCount = 0;
        int totalSum = 0;

        for (int i = 0; i < c.length; i++) {

            char ch = c[i];

            if (ch == '[') {
                currentLevelCount++;
                continue;
            }
            if (ch == ']') {
                currentLevelCount--;
                continue;
            }
            if (ch == ',') {
                continue;
            }
            totalSum += currentLevelCount * (ch - '0');
        }

        return totalSum;
    }
}
