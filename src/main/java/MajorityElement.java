/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class MajorityElement {

    public static void main(String[] args) {
        int[] a = {3,2,3};

        System.out.println(majorityElement(a));
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int count = 1;
        int majority_element = nums[0];

        // Step 1 - Finding majority element candidate
        for (int i = 1; i < nums.length; i++) {
            if (majority_element == nums[i]) {
                count++;
            } else if (count == 0) {
                majority_element = nums[i];
                count = 1;
            } else {
                count--;
            }
        }

        count = 0;

        // Step 2 - Confirming above candidate is majority element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority_element) {
                count++;
            }
        }

        if (count > (nums.length / 2))
            return majority_element;
        else
            return -1;

    }

}
