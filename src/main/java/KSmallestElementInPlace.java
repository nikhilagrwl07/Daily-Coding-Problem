/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class KSmallestElementInPlace {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 6, 7, 3, 4, 20, 3};
        int k = 5;

        findKSmallestElementInPlace(arr, k);
    }

    private static void findKSmallestElementInPlace(int[] a, int k) {
        if (a == null || a.length == 0 || k > a.length || k < 0) {
            return;
        }

        int current = k;

        for (; current <= a.length - 1; current++) {
            int maxIndex = findMax(a, 0, k - 1);

            if (a[current] < a[maxIndex]) {
                if (maxIndex == k - 1) { // No left shifting required
                    swap(a, current, maxIndex);
                } else {
                    int tempMaxValue = a[maxIndex];
                    shiftElementToLeft(a, maxIndex, k - 1);
                    a[k - 1] = a[current];
                    a[current] = tempMaxValue;
                }

            }
        }

        printKSmallestElementPreservingOrder(a, k);
    }

    private static void printKSmallestElementPreservingOrder(int[] a, int k) {
        for (int i = 0; i < k; i++)
            System.out.print(a[i] + " ");

    }

    private static void swap(int[] a, int current, int maxIndex) {

        int temp = a[current];
        a[current] = a[maxIndex];
        a[maxIndex] = temp;
    }

    private static void shiftElementToLeft(int[] a, int lowerIndex, int upperIndex) {

        for (int i = lowerIndex+1; i <= upperIndex; i++) {
            a[i - 1] = a[i];
        }
    }

    private static int findMax(int[] a, int l, int h) {
        int max = Integer.MIN_VALUE, maxIndex = -1;


        while (l <= h) {
            if (a[l] > max) {
                max = a[l];
                maxIndex = l;
            }

            l++;
        }
        return maxIndex;

    }
}
