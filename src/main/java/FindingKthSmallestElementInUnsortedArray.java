package main.java;

public class FindingKthSmallestElementInUnsortedArray {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        System.out.print("K'th smallest element is " +
                kthSmallest(arr, 0, arr.length - 1, k));
    }

    // This function returns k'th smallest element
    // in a[left..right] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    public static int kthSmallest(Integer[] a, int left, int right, int k) {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= right - left + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(a, left, right);

            // If position is same as k
            if (pos - left == k - 1)
                return a[pos];

            // If position is more, recur for
            // left subarray
            if (pos - left > k - 1)
                return kthSmallest(a, left, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(a, pos + 1, right, k - 1 + left - pos); // Not able to understand this part, hence
            // ignoring the solution
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    // Standard partition process of QuickSort.
    // It considers the last element as pivot
    // and moves all smaller element to left of
    // it and greater elements to right
    public static int partition(Integer[] arr, int l,
                                int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                //Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        //Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }
}

