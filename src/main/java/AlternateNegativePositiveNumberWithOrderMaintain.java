package main.java;

public class AlternateNegativePositiveNumberWithOrderMaintain {

    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8, -9};
        print(arr);
        alternateWithOrdering(arr);
    }


    private static void alternateWithOrdering(int[] a) {

        if (a == null || a.length <= 2) {
            return;
        }

        int countOfPositiveNumber = countOfPositiveNumber(a);
        int startingIndexOfPositiveNumber = a.length - countOfPositiveNumber;
        collectElement(a, startingIndexOfPositiveNumber);

        print(a);

        alternateWithOrderingUtil(a, startingIndexOfPositiveNumber);
        print(a);
    }

    private static void alternateWithOrderingUtil(int[] a, int right) {

        int newLeft = 0;
        int currentIndex = 0;
        while (newLeft <= right - 1 && right <= a.length - 1 && currentIndex < a.length) {

            if (currentIndex % 2 == 0) { // even

                int rightelement = a[right];

                shiftByOnePlace(a, currentIndex, right);
                a[currentIndex] = rightelement;

                right++;
                newLeft++;
            } else {
                a[currentIndex] = a[newLeft];
                newLeft++;
            }
            currentIndex++;
        }
    }

    private static void collectElement(int[] a, int startingIndexOfPositiveNumber) {

        int negative = 0;
        int positive = startingIndexOfPositiveNumber;

        while (negative <= (startingIndexOfPositiveNumber - 1) && positive <= a.length - 1) {
            if (a[negative] > 0) {
                int firstNegativeIndex = findFirstNegativeNumber(a, positive);

                if (firstNegativeIndex == -1) {
                    return;
                } else {
                    shiftByOnePlace(a, positive, firstNegativeIndex);
                    swap(a, negative, positive);
                    positive++;
                }
            }
            negative++;
        }

    }

    private static void shiftByOnePlace(int[] a, int positive, int firstNegativeIndex) {

        int temp = a[firstNegativeIndex];
        for (int i = firstNegativeIndex - 1; i >= positive; i--) {
            a[i + 1] = a[i];
        }
        a[positive] = temp;
    }

    private static void swap(int[] a, int negative, int firstNegativeIndex) {

        int t = a[negative];
        a[negative] = a[firstNegativeIndex];
        a[firstNegativeIndex] = t;
    }

    private static int findFirstNegativeNumber(int[] a, int positiveIndex) {

        for (int i = positiveIndex; i <= a.length - 1; i++) {
            if (a[i] < 0)
                return i;
        }
        return -1;

    }

    private static int countOfPositiveNumber(int[] a) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
