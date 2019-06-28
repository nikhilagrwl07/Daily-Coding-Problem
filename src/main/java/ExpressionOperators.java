package main.java;

public class ExpressionOperators {
    public static void main(String[] args) {
        String input = "123";
        char[] operators = {'+', '-', '*'};
        int target = 6;

        char[] result = new char[input.length() + input.length() - 1];
        char[] inputChar = input.toCharArray();

        generateExpression(inputChar, operators, result, 0, target);
    }

    private static void generateExpression(char[] inputChar,
                                           char[] operators, char[] result, int resultIndex, int target) {

        if (inputChar == null || operators == null) {
            return;
        }
        if (resultIndex >= result.length - 1) {
            evaluate(result, target);
            return;
        }

        for (int i = 0; i < inputChar.length; i++) {
            if (resultIndex == 0) {
                result[resultIndex] = inputChar[i];
            } else {
                result[++resultIndex] = inputChar[i];
            }


            for (int j = 0; j < operators.length && (resultIndex < result.length - 1); j++) {

                result[resultIndex + 1] = operators[j];
                generateExpression(inputChar, operators, result, resultIndex + 1, target);
            }

        }
    }

    private static void evaluate(char[] result, int target) {

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();

//        int totalSum = 0;
//
//        for(int i=0;i<result.length; i++){
//
//            if(result[i] == '*')
//            {
//                totalSum += (result[i-1] - '0') * (result[i+1] - '0');
//            }
//        }
//
//        for(int i=0;i<result.length; i++){
//
//            if(result[i] == '*')
//            {
//                totalSum += (result[i-1] - '0') * (result[i+1] - '0');
//            }
//        }
    }
}
