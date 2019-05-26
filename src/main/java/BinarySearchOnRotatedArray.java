package main.java;

public class BinarySearchOnRotatedArray {

    public static void main(String[] args) {
        int a[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 2;
        int indexOfKey = searchElement(a, key);

        System.out.println("Element - " + key + " Index found - " + indexOfKey);

    }

    private static int searchElement(int[] a, int key) {
        if (a == null)
            return -1;

        if (a.length == 1 && a[0] == key)
            return 0;

        int pivotIndex = pivot(a, 0, a.length - 1);
        if (key == a[pivotIndex])
            return pivotIndex;


        if (a[0] <= key && key < a[pivotIndex]) {
            return binarySearch(a, 0, pivotIndex-1, key);
        } else
            return binarySearch(a, pivotIndex+1, a.length-1, key);
    }

    private static int binarySearch(int[] a, int lower, int higher, int key) {

        if (higher < lower)
            return -1;

        int mid = lower + (higher - lower) / 2;

        if (key == a[mid])
            return mid;

        if (key < a[mid])
            return binarySearch(a, lower, mid - 1, key);
        else
            return binarySearch(a, mid + 1, higher, key);
    }

    private static int pivot(int[] a, int lower, int higher) {

        if (lower > higher)
            return -1;

        if (lower == higher)
            return lower;

        int mid = lower + (higher - lower) / 2;

        if (lower < mid && a[mid - 1] > a[mid])
            return mid - 1;

        if (mid < higher && a[mid] > a[mid + 1])
            return mid;

        if (a[lower] > a[mid])
            return pivot(a, lower, mid - 1);
        else
            return pivot(a, mid + 1, higher);
    }
}
