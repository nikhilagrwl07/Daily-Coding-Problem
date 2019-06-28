package main.java;

// Ordering is not maintained
public class AlternateNegativePositiveNumber {

    public static void main(String[] args) {
        int[] a = {-1, 2, -10, -3, 1, 10, -7, -100};

        print(a);
        alternate(a);
        print(a);
    }


    static void alternate(int[] a) {
        if (a == null || a.length == 1 || a.length == 2) {
            return;
        }

        // collect all +ive at rightside and -ive at left side

        int right = a.length - 1, left = 0;

        while (left < right) {

            boolean isLeftPositive = false;
            boolean isRightNegative = false;

            if (a[left] > 0) {
                isLeftPositive = true;
            } else {
                left++;
            }
            if (a[right] < 0) {
                isRightNegative = true;
            } else {
                right--;
            }

            if (isLeftPositive && isRightNegative) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }

        }
        // place positive --> even location
        // place negative --> odd location

        int newLeft = 0;
        int newRight = right;
        int currentIndex = 0;
        while (newLeft <= right - 1 && newRight <= a.length - 1 && currentIndex < a.length) {

            if (currentIndex % 2 == 0) { // even
                int temp = a[currentIndex];
                a[currentIndex] = a[newRight];
                a[newRight] = temp;
                newRight++;
                right++;
                newLeft++;
            } else {
                a[currentIndex] = a[newLeft];
                newLeft++;
            }
            currentIndex++;
        }
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
