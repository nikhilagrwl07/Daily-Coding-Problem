package main.java;

public class MaximumSumCombinationsFromTwoArrays {
    public static void main(String[] args) {
        int[] firstArray = {4, 2, 5, 1};
        int[] secondArray = {8, 0, 3, 5};
        int k = 3;

//        int[] firstArray = {3,2};
//        int[] secondArray = {1,4};
//        int k = 2;

        int[] ans = maximumKSumCombination(firstArray, secondArray, k);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    private static int[] maximumKSumCombination(int[] firstArray, int[] secondArray, int k) {

        int[] maxHeapOfFirstArray = new int[k];
        constructMaxHeap(firstArray, maxHeapOfFirstArray);

        int[] maxHeapOfSecondArray = new int[k];
        constructMaxHeap(secondArray, maxHeapOfSecondArray);

        int[] ans = new int[k];
        int firstMaxHeap = k - 1;
        int secondMaxHeap = k - 1;

        for (int i = 0; i < k; i++) {

            ans[i] = maxHeapOfFirstArray[0] + maxHeapOfSecondArray[0];

            if (maxHeapOfFirstArray[0] > maxHeapOfSecondArray[0]) {
                maxHeapOfSecondArray[0] = maxHeapOfSecondArray[secondMaxHeap];
                secondMaxHeap--;
                heapifyTopDownApproach(maxHeapOfSecondArray, 0, secondMaxHeap);
            } else {
                maxHeapOfFirstArray[0] = maxHeapOfFirstArray[firstMaxHeap];
                firstMaxHeap--;
                heapifyTopDownApproach(maxHeapOfFirstArray, 0, firstMaxHeap);

            }
        }
        return ans;
    }

    private static void constructMaxHeap(int[] inputArray, int[] outputArray) {

        int i;
        for (i = 0; i < outputArray.length; i++) {
            outputArray[i] = inputArray[i];
        }

        heapifyTopDownApproach(outputArray, 0, outputArray.length - 1);

        for (; i < inputArray.length - 1; i++) {
            if (inputArray[i] > outputArray[0]) {
                outputArray[outputArray.length - 1] = inputArray[i];
                heapifyBottomup(outputArray, outputArray.length - 1);
            }
        }
    }

    private static void heapifyBottomup(int[] outputArray, int index) {

        if (outputArray[getParent(index)] < outputArray[index]) {
            swap(outputArray, getParent(index), index);
            heapifyBottomup(outputArray, getParent(index));
        }

    }

    private static int getParent(int index) {
        return (index - 1) / 2;
    }

    private static void heapifyTopDownApproach(int[] a, int index, int size) {

        int largestIndex = index;

        if (getLeft(index) <= size && a[largestIndex] < a[getLeft(index)]) {
            largestIndex = getLeft(index);
        }

        if (getRight(index) <= size && a[largestIndex] < a[getRight(index)]) {
            largestIndex = getRight(index);
        }

        if (largestIndex != index) {
            swap(a, largestIndex, index);
            heapifyTopDownApproach(a, largestIndex, size);
        }
    }

    private static void swap(int[] a, int i1, int i2) {
        int t = a[i1];
        a[i1] = a[i2];
        a[i2] = t;
    }

    private static int getLeft(int index) {
        return (2 * index) + 1;
    }

    private static int getRight(int index) {
        return (2 * index) + 2;
    }
}
