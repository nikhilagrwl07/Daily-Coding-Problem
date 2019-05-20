package main.java;

    public class MaxHeap {
    public static void main(String[] args) {

        int[] a = {-1, 10, 4, 1, 30, 100, 60, 79};

        buildMaxHeap(a, a.length - 1, (a.length - 1) / 2);

        print(a);

        heapsort(a);

        print(a);

    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void heapsort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        for (int i = a.length - 1; i >= 0; i--) {

            swap(a, 0, i);
            buildMaxHeap(a, i - 1, 0);
        }

    }

    private static void buildMaxHeap(int[] a, int totalLength, int index) {


        for (; index >= 0; index--) {
            int largestIndex = index;

            if (getLeft(index) <= totalLength && a[largestIndex] < a[getLeft(index)])
                largestIndex = getLeft(index);

            if (getRight(index) <= totalLength && a[largestIndex] < a[getRight(index)])
                largestIndex = getRight(index);

            if (largestIndex != index) {
                swap(a, largestIndex, index);
                buildMaxHeap(a, totalLength, largestIndex);
            }
        }

    }

    private static void swap(int[] a, int largestIndex, int indexOfEnd) {
        int temp = a[largestIndex];
        a[largestIndex] = a[indexOfEnd];
        a[indexOfEnd] = temp;
    }

    private static int getLeft(int index) {
        return 2 * index + 1;
    }

    private static int getRight(int index) {
        return 2 * index + 2;
    }
}
