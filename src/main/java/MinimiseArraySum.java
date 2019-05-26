package main.java;

public class MinimiseArraySum {
    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7, 6};

        buildMinHeap(a, a.length - 1, (a.length - 1) / 2);

        int sum = minimiseArraySum(a);
        System.out.println("sum = " + sum);

    }

    private static int minimiseArraySum(int[] minHeap) {
        if (minHeap == null)
            return -1;

        int heapSize = minHeap.length - 1;
        int sum = 0;
        while (heapSize >= 1) {
            int firstMinimumElement = minHeap[0];
            swap(minHeap, 0, heapSize);
            buildMinHeap(minHeap, heapSize - 1, 0);

            heapSize--;

            int secondMinimumElement = minHeap[0];

            int tempSum = firstMinimumElement + secondMinimumElement;
            sum += tempSum;
            minHeap[0] = tempSum;
            buildMinHeap(minHeap, heapSize, 0);
        }

        return sum;
    }


    private static void heapsort(int[] a) {
        if (a == null || a.length == 1) {
            return;
        }

        for (int i = a.length - 1; i >= 0; i--) {

            swap(a, 0, i);
            buildMinHeap(a, i - 1, 0);
        }

    }

    private static void buildMinHeap(int[] a, int totalLength, int index) {


        for (; index >= 0; index--) {
            int smallesIndex = index;

            if (getLeft(index) <= totalLength && a[smallesIndex] > a[getLeft(index)])
                smallesIndex = getLeft(index);

            if (getRight(index) <= totalLength && a[smallesIndex] > a[getRight(index)])
                smallesIndex = getRight(index);

            if (smallesIndex != index) {
                swap(a, smallesIndex, index);
                buildMinHeap(a, totalLength, smallesIndex);
            }
        }

    }

    private static void swap(int[] a, int smallestIndex, int indexOfEnd) {
        int temp = a[smallestIndex];
        a[smallestIndex] = a[indexOfEnd];
        a[indexOfEnd] = temp;
    }

    private static int getLeft(int index) {
        return 2 * index + 1;
    }

    private static int getRight(int index) {
        return 2 * index + 2;
    }
}
