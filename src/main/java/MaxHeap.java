package main.java;

public class MaxHeap {
    public static void main(String[] args) {

        int[] a = {-1, 10, 4, 1, 30, 100, 60};

        buildMaxHeap(a);

        print(a, "Before Heap Sort. Only Build Max Heap");

        heapsort(a);

        print(a, "After Heap Sort");

    }

    private static void buildMaxHeap(int[] a) {
        int indexFromEndToZero = (a.length - 1) / 2;

        for (; indexFromEndToZero >= 0; indexFromEndToZero--) {
            heapifyTopDownApproach(a, a.length - 1, indexFromEndToZero);
        }

    }

    private static void heapsort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        for (int heaplength = a.length - 1; heaplength >= 0; heaplength--) {

            swap(a, 0, heaplength);
            heapifyTopDownApproach(a, heaplength - 1, 0);
        }

    }

    private static void heapifyTopDownApproach(int[] a, int totalLength, int index) {


        for (; index >= 0; index--) {
            int largestIndex = index;

            if (getLeft(index) <= totalLength && a[largestIndex] < a[getLeft(index)])
                largestIndex = getLeft(index);

            if (getRight(index) <= totalLength && a[largestIndex] < a[getRight(index)])
                largestIndex = getRight(index);

            if (largestIndex != index) {
                swap(a, largestIndex, index);
                heapifyTopDownApproach(a, totalLength, largestIndex);
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


    private static void print(int[] a, String msg) {
        System.out.println(msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
