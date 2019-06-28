/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class MaximumProductSubarray {
    public static void main(String[] args) {
//        int[] a = {2, 3, -2, 4};
//        int[] a = {-4,-3};
        int[] a = {-2, 3, -4};
//        int[] a = {-2, -3, 7};

        System.out.println(maximumProductSubarray(a));
    }

    private static int maximumProductSubarray(int[] a) {
        if (a == null || a.length == 0)
            return 0;

        if (a.length == 1) {
            return a[0];
        }

//        boolean containsZero = containsZero(a);

        int maxProductSoFar = Integer.MIN_VALUE;
        int currentProduct = 1;

        for (int i = 0; i < a.length; i++) {

            if (currentProduct < 0) {

                if (a[i] < 0) {
                    currentProduct = currentProduct * a[i];
                } else {
                    currentProduct = a[i];
                }


            } else {
                currentProduct = currentProduct * a[i];
            }

            maxProductSoFar = Math.max(currentProduct, maxProductSoFar);
            maxProductSoFar = Math.max(a[i], maxProductSoFar);
        }
        return maxProductSoFar;


    }

}
