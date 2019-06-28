/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class MaxProfitWithMultipleTransactions {
    public static void main(String[] args) {
//        int[] a = {7, 1, 5, 3, 6, 4};
        int[] a = {7,6,4,3,1};

        System.out.println(maxProfit(a));

    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int totalProfit = 0;
        for (int i = 0; i <= prices.length - 2; i++) {

            if (prices[i] < prices[i + 1]) {
                totalProfit += prices[i + 1] - prices[i];
            }
        }

        return totalProfit;
    }
}
