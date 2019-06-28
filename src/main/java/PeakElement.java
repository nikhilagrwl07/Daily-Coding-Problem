/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class PeakElement {
    public static void main(String[] args) {
//        int[] a = {1, 2, 1, 3, 5, 6, 4};
//        int[] a = {3, 4, 3, 2, 1};
//        int[] a = {2, 1};
        int[] a = {4, 3, 2, 1};

        System.out.println(findPeakElement(a));

    }

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 0;

        return findPeakElementUtil(nums, 0, nums.length - 1);

    }

    public static int findPeakElementUtil(int[] nums, int low, int high) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

//        System.out.println("low - " + low + " Mid - " + mid + " High - " + high);

        if (mid - 1 >= 0 && mid + 1 <= nums.length - 1 && nums[mid - 1] < nums[mid]
                && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (mid == 0 && mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (mid == nums.length - 1 && mid - 1 >= 0 && nums[mid] > nums[mid - 1]) {
            return mid;
        }

        int right = findPeakElementUtil(nums, mid + 1, high);
        int left = findPeakElementUtil(nums, low, mid - 1);

        if (right != -1) {
            return right;
        }
        if (left != -1)
            return left;

        return -1;

    }
}
