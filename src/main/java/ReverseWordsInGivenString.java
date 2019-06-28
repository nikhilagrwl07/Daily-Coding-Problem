package main.java;

public class ReverseWordsInGivenString {

    public static void main(String[] args) {
        String input = "i like this program very much";
        System.out.println(input);

        String reverseWordsInGivenString = reverseWordsInGivenString(input);
        System.out.println(reverseWordsInGivenString);

    }

    private static String reverseWordsInGivenString(String input) {

        if (input == null || input.length() == 1)
            return input;

        StringBuilder sb = new StringBuilder();

        char[] c = input.toCharArray();
        StringBuilder sbSmall = new StringBuilder();

        for (int i = 0; i < c.length; i++) {

            if (c[i] == ' ') {
                String smallString = sbSmall.toString();

                if (sb.toString().isEmpty()) {
                    sb.insert(0, smallString);
                } else {

                    sb.insert(0, " ");
                    sb.insert(0, smallString);
                }

                sbSmall = new StringBuilder();
            } else {
                sbSmall.append(c[i]);
            }
        }

        String smallString = sbSmall.toString();
        sb.insert(0, " ");
        sb.insert(0, smallString);

        return sb.toString();

    }
}
