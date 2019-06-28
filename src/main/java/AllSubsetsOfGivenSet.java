/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsOfGivenSet {
    public static void main(String[] args) {
        int[] a = {-1, 1, 2};
        System.out.println(Arrays.toString(a));

        // Iterative bit-wise non-intuitive approach
//        List<List<Integer>> subsets = subsets(a);
//        System.out.println(subsets);


        // Recursive intuitive approach
        subsetsRecursive(a, 0, new int[a.length], 0);
        System.out.println(ans);
    }

    static List<List<Integer>> ans = new ArrayList<>();

    private static void subsetsRecursive(int[] nums, int numsIndex, int[] result, int resultIndex) {

        if (numsIndex == nums.length) {
            List<Integer> l = new ArrayList<>();

            for (int i = 0; i < resultIndex; i++) {
                l.add(result[i]);
            }
            ans.add(l);

            return;
        }


        // including nums[numsIndex]
        result[resultIndex] = nums[numsIndex];
        subsetsRecursive(nums, numsIndex + 1, result, resultIndex + 1);

        // not including nums[numsIndex]
        subsetsRecursive(nums, numsIndex + 1, result, resultIndex);

    }


    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        List<List<Integer>> subsets = new ArrayList<>();

        // outer loop --> current set number from (2^n) total possible sets
        // inner loop --> 1<< jth is number with jth bit set as 1 and then doing and with set number
        //                gives number present in that set
        for (int setNumber = 0; setNumber < Math.pow(2, nums.length); setNumber++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {

                int numberWithJthBitSetAsOne = 1 << j;

                if ((setNumber & numberWithJthBitSetAsOne) > 0) {
//                    System.out.println("number - " + j);
                    list.add(nums[j]);
                }
            }
//            if(!list.isEmpty())
            subsets.add(list);
        }
        return subsets;
    }

}
