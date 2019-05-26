package main.java;

public class SearchingClosestElement {

    public static void main(String[] args) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int element = 14;

        findClosestElement(arr, element);
//        System.out.println(arr[closestElement]);


    }

    //Given - array is already sorted
    private static void findClosestElement(int[] a, int element) {
        int low = 0, high = a.length - 1;


        // Corner cases
        if (a[high] < element) {
            System.out.println(a[high]);
            return;
        }

        if (element < a[low]) {
            System.out.println(a[low]);
            return;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // element == mid
            if (a[mid] == element) {

                int leftDiff = Integer.MAX_VALUE;
                int rightDiff = Integer.MAX_VALUE;

                if (mid > 0) {
                    leftDiff = element - a[mid - 1];
                }

                if (mid < a.length - 1) {
                    rightDiff = a[mid + 1] - element;
                }


                if (leftDiff != Integer.MAX_VALUE && leftDiff < rightDiff) {
                    System.out.println(a[mid - 1]);
                } else if (rightDiff != Integer.MAX_VALUE) {
                    System.out.println(a[mid + 1]);
                }
                return;
            }

            // element < mid
            if (element < a[mid]) {

                if (low <= mid - 1 && a[mid - 1] < element) {   // Cross over point is mid-1 to mid
                    System.out.println(getClosest(element, a[mid - 1], a[mid]));
                    return;
                } else
                    high = mid;
            } else {
                if (mid + 1 <= high && element < a[mid + 1]) { // Cross over point is mid to mid+1
                    System.out.println(getClosest(element, a[mid], a[mid + 1]));
                    return;
                } else
                    low = mid + 1;
            }
        }

    }

    private static int getClosest(int element, int lower, int higher) {
        int lowDiff = element - lower;
        int highDiff = higher - element;

        if (lowDiff < highDiff) {
            return lower;
        } else {
            return higher;
        }

    }

}
