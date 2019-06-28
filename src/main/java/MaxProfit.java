/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};

        System.out.println(maxProfit(a));

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int maxElementSoFar = prices[prices.length - 1];
        int maxDifference = Integer.MIN_VALUE;

        for (int i = prices.length - 2; i >= 0; i--) {
            int currentElement = prices[i];

            if (currentElement < maxElementSoFar) {
                int currentDiff = maxElementSoFar - currentElement;

                if (currentDiff > maxDifference){
                    maxDifference= currentDiff;
                }
            }
            else
            {
                maxElementSoFar = currentElement;
            }
        }

        if (maxDifference == Integer.MIN_VALUE){
            maxDifference = 0;
        }

        return maxDifference;
    }
}
