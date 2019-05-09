package main.java;

import java.util.HashSet;
import java.util.Set;

public class FindPairsInArrayWithSumK {

    //10, 15, 3, 7
    public static void main(String[] args) {
        int[] a = new int[4];
        a[0] = 10;
        a[1] = 3;
        a[2] = 10;
        a[3] = 7;
        int sum = 20;

        if (isPairWithSumKPresentinArray(a, sum)) {
            System.out.println("Pair is present");
        } else
            System.out.println("Pair is not present");
    }


    private static boolean isPairWithSumKPresentinArray(int[] a, int sum) {

        if (a == null || a.length <= 1) {
            return false;
        }
        mergeSort(a, 0, a.length - 1);


        int low = 0, high = a.length - 1;

        while (low < high) {
            if (a[low] + a[high] == sum) {
                return true;
            }
            if (a[low] + a[high] < sum) {
                low++;
            }

            if (a[low] + a[high] > sum) {
                high--;
            }
        }

        return false;
    }


    private static void mergeSort(int[] a, int low, int high) {

        if (low >= high)
            return;

        int mid = low + ((high - low) / 2);

        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];

        int lowOfSecondArray = mid + 1;
        int currentIndexOfTmp = 0;
        int tmpLow = low;

        while (low <= mid && lowOfSecondArray <= high) {
            if (a[low] <= a[lowOfSecondArray]) {
                tmp[currentIndexOfTmp] = a[low];
                low++;
            } else {
                tmp[currentIndexOfTmp] = a[lowOfSecondArray];
                lowOfSecondArray++;
            }
            currentIndexOfTmp++;
        }

        if (lowOfSecondArray > high) {

            while (low <= mid) {
                tmp[currentIndexOfTmp] = a[low];
                low++;
                currentIndexOfTmp++;
            }
        } else {

            while (lowOfSecondArray <= high) {
                tmp[currentIndexOfTmp] = a[lowOfSecondArray];
                lowOfSecondArray++;
                currentIndexOfTmp++;
            }

        }

        for (int i = 0; i < currentIndexOfTmp; i++) {
            a[tmpLow + i] = tmp[i];
        }
    }


    // Approach #2 - Using HashSet --> this method will fail in case duplicate. Will work ony with Hashtable
    // where key is element of given array , value is frequency of occurrence of element
    public boolean isPairWithSumKPresentUsingHashSet(int[] a, int sum){
        return false;
    }
}
