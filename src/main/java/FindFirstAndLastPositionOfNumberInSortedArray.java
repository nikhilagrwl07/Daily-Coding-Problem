/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.Arrays;

public class FindFirstAndLastPositionOfNumberInSortedArray {
    public static void main(String[] args) {
//        int[] a = {5, 7, 7, 8, 8, 10};
        int[] a = {1};
        int target = 1;

        System.out.println(Arrays.toString(searchRange(a, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstOccu = firstOccurence(nums, 0, nums.length - 1, target);
        int lastOccu = lastOccurence(nums, 0, nums.length - 1, target);

        int[] result = new int[2];

        result[0] = firstOccu;
        result[1] = lastOccu;
        return result;
    }

    private static int lastOccurence(int[] nums, int l, int h, int target) {

        if (l > h)
            return -1;
        int mid = l + (h - l) / 2;

        // Case 1 - mid == target
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                return mid;
            } else {
                return lastOccurence(nums, mid + 1, h, target);
            }
        }

        //Case 2 - mid > target
        if (nums[mid] > target) {
            return lastOccurence(nums, l, mid - 1, target);
        }
        //Case 3 - mid < target
        return lastOccurence(nums, mid + 1, h, target);
    }

    private static int firstOccurence(int[] nums, int l, int h, int target) {

        if (l > h)
            return -1;
        int mid = l + (h - l) / 2;

        // Case 1 - mid == target
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] < nums[mid]) {
                return mid;
            } else {
                return firstOccurence(nums, l, mid - 1, target);
            }
        }

        //Case 2 - mid > target
        if (nums[mid] > target) {
            return firstOccurence(nums, l, mid - 1, target);
        }
        //Case 3 - mid < target
        return firstOccurence(nums, mid + 1, h, target);

    }
}

