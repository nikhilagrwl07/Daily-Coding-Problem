package main.java;

public class SquareRootUsingBinarySearch {

    public static void main(String[] args) {

        int x = 4;
        System.out.println(squareRootUsingBinarySearch(x));
        x = 5;
        System.out.println(squareRootUsingBinarySearch(x));

        x = 16;
        System.out.println(squareRootUsingBinarySearch(x));

        x = 24;
        System.out.println(squareRootUsingBinarySearch(x));
    }

    // Floor square root of an element
    private static int squareRootUsingBinarySearch(int x) {

        // case 1
        if (x == 0 || x == 1)
            return x;


        int low = 1, high = x;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // case 2 -
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid < x) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
