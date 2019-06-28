package main.java;

/*
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)

Time Complexity - O(k) + O((n-k) * log(k))) = O(nlogk)
Space Complexity - O(k)
 */
public class FindMaximumValueInSubArrayOfLengthK {
    public static void main(String[] args) {
//        int[] a = {10, 5, 2, 7, 8, 7};
        int[] a = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int windowSize = 3;

        maximumElementInSubarrayOfSizeK(a, windowSize);
    }

    private static void maximumElementInSubarrayOfSizeK(int[] a, int windowSize) {
        if (a == null || a.length < windowSize) {
            return;
        }

        int low = 0;
        int high = windowSize - 1;

        int[] maxHeap = constructMaxHeap(a, low, high);

        while (high <= a.length - 1) {
            int maxElement = maxHeap[0];
            System.out.println(maxElement);
            int elementToBeDeleted = a[low];

            if (high + 1 <= a.length - 1) {
                int elementToBeInserted = a[high + 1];
                low++;
                high++;
                deleteAndInsert(maxHeap, elementToBeDeleted, elementToBeInserted);
            } else {
                return;
            }
        }

    }

    private static void deleteAndInsert(int[] maxHeap, int elementToBeDeleted, int elementToBeInserted) {

        //deletion part
        for (int i = 0; i <= maxHeap.length - 1; i++) {
            if (maxHeap[i] == elementToBeDeleted) {
                maxHeap[i] = maxHeap[maxHeap.length - 1];
                maxHeapifyTopDown(maxHeap, i, maxHeap.length - 2);
                break;
            }
        }

        // addition part
        maxHeap[maxHeap.length - 1] = elementToBeInserted;
        maxHeapifyBottomUp(maxHeap, maxHeap.length - 1, 0);
    }

    private static int[] constructMaxHeap(int[] a, int low, int high) {
        int[] maxHeap = new int[high - low + 1];


        for (int i = low; i <= high; i++) {
            maxHeap[i] = a[i];
        }

        for (int i = (high - 1) / 2; i >= low; i--) {
            maxHeapifyTopDown(maxHeap, i, high);
        }

        return maxHeap;
    }


    private static void maxHeapifyBottomUp(int[] a, int currentIndex, int lastIndex) {

        if (currentIndex < lastIndex)
            return;

        int largestIndex = currentIndex;

        if (getParent(largestIndex) >= lastIndex && a[largestIndex] > a[getParent(largestIndex)]) {
            largestIndex = getParent(largestIndex);
        }

        if (largestIndex != currentIndex) {
            swap(a, largestIndex, currentIndex);
            maxHeapifyBottomUp(a, largestIndex, lastIndex);
        }
    }


    private static void maxHeapifyTopDown(int[] a, int currentIndex, int lastIndex) {

        if (currentIndex >= lastIndex)
            return;

        int largestIndex = currentIndex;

        if (getLeft(currentIndex) <= lastIndex && a[largestIndex] < a[getLeft(currentIndex)]) {
            largestIndex = getLeft(currentIndex);
        }

        if (getRight(currentIndex) <= lastIndex && a[largestIndex] < a[getRight(currentIndex)]) {
            largestIndex = getRight(currentIndex);
        }

        if (largestIndex != currentIndex) {
            swap(a, largestIndex, currentIndex);
            maxHeapifyTopDown(a, largestIndex, lastIndex);
        }
    }

    private static void swap(int[] a, int largestIndex, int currentIndex) {
        int t = a[largestIndex];
        a[largestIndex] = a[currentIndex];
        a[currentIndex] = t;
    }

    private static int getLeft(int currentIndex) {
        return 2 * currentIndex + 1;
    }

    private static int getRight(int currentIndex) {
        return 2 * currentIndex + 2;
    }

    private static int getParent(int currentIndex) {
        return (currentIndex - 1) / 2;
    }
}
