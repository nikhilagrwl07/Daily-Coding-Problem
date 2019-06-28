/*Problem - Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

Solution -
Time Complexity - O(n^2)
Space Complexity - O(1)

    */


package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithGivenSum {

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};

        TripletWithGivenSum ob = new TripletWithGivenSum();

        List<List<Integer>> triplets = ob.threeSum(a);
        System.out.println(triplets);


    }

    private List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        int targetSum = 0;
        List<List<Integer>> ans = new ArrayList<>();

        List<Triplet> triplets = new ArrayList<>();

        for (int i = 0; i <= nums.length - 3; i++) {
            int newTargetSum = targetSum - nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int currentSum = nums[left] + nums[right];

                if (newTargetSum == currentSum) {

                    Triplet tripl = new Triplet(nums[i], nums[left], nums[right]);

                    if (!triplets.contains(tripl)) {
                        triplets.add(tripl);
                        ans.add(tripl.toList());
                    }

                    left++;
                    right--;
                } else if (newTargetSum > currentSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    class Triplet {
        int a, b, c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplets = (Triplet) o;
            return a == triplets.a &&
                    b == triplets.b &&
                    c == triplets.c;
        }

        public List<Integer> toList() {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            return list;
        }
    }
}
