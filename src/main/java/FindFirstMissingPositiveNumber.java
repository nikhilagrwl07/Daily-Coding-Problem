package main.java;

// Requirement :
// - Time Complexity - O(n)
// - Space Complexity - O(1)

public class FindFirstMissingPositiveNumber {

    public static void main(String[] args) {
//        int[] a = {3, 4, -1, 1};
//        int[] a = {1, 2, 0};
        int[] a = {0, 10, 1, -10, -20};
        int firstMissingPositiveNumber = findFirstMissingPositiveNumber(a);
        System.out.println(firstMissingPositiveNumber);

    }

    private static int findFirstMissingPositiveNumber(int[] a) {
        if (a == null || a.length == 0)
            return -1;

        int endingIndexOfPositiveNumber = segregate(a);

        if (endingIndexOfPositiveNumber < 0) {
            System.out.println("All numbers are negatives!! No first missing positive number..");
            return -1;
        }

        return findFirstMissingPositiveNumberWithGivenSize(a, endingIndexOfPositiveNumber);
    }

    private static int findFirstMissingPositiveNumberWithGivenSize(int[] a, int endingIndexOfPositiveNumber) {

        for (int i = 0; i <= endingIndexOfPositiveNumber; i++) {

            int numberAti = Math.abs(a[i]); // Very important to note Math.abs() as value at index i could have been changed previously
                                            // before reaching there with index i
            if (numberAti > 0 && (numberAti - 1) <= a.length - 1) {
                a[numberAti - 1] = -a[numberAti - 1];
            }
        }

        int i;
        for (i = 0; i <= endingIndexOfPositiveNumber; i++) {
            if (a[i] > 0)
                return i + 1;
        }

        return i + 1;
    }


    private static int segregate(int[] arr) {
        int tmp = 0;

        for (int index = 0; index < arr.length; index++) {
            if (arr[index] > 0) {
                swap(arr, tmp, index);
                tmp++;
            }
        }
        return tmp - 1;
    }

    private static void swap(int[] arr, int tmp, int index) {
        int pTemp = arr[tmp];
        arr[tmp] = arr[index];
        arr[index] = pTemp;
    }
}
