/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
//        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int a[] = {2,3,1,1,4};
        int a[] = {1, 3, 6, 1, 0, 9};


        // Recursive approach
        int minimimJumpsToReachEnd = minimumJumpsToReachEnd(a, 0, a.length - 1);

        if (minimimJumpsToReachEnd == Integer.MAX_VALUE) {
            System.out.println("Unreachable");
        } else {
            System.out.println("Minimum steps required = " + minimimJumpsToReachEnd);
        }

        // Dynamic Programing approach
        System.out.println(minimumJumpsToReachEndUsingDPapproach(a));

    }


    // Dynamic Programming approach
    // Time Complexity = O(n^2)
    private static int minimumJumpsToReachEndUsingDPapproach(int[] nums) {

        if (nums == null || nums.length <= 1)
            return 1;

        int[] jumps = new int[nums.length];

        jumps[0] = 0;

        for (int i = 1; i <= nums.length - 1; i++) {
            jumps[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {

                if (i <= j + nums[j] && jumps[j] != Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[j]+1, jumps[i]);
                }
            }
        }
        return jumps[nums.length-1];

    }

    // Recursively calling all jumps from current.
    // Then find minimum jumps from all combinations
    // Time Complexity = O(!n)
    private static int minimumJumpsToReachEnd(int[] a, int low, int high) {
        if (low > high)
            return Integer.MAX_VALUE;

        if (low == high) {
            return 0;
        }

        if (a[low] == 0)
            return Integer.MAX_VALUE;

        int minSteps = Integer.MAX_VALUE;

        int maxPossibleJumps = a[low];

        for (int i = 1; i <= maxPossibleJumps; i++) {
//            System.out.println("low - " + (low+i)+  "  High - "+  high);
            minSteps = Math.min(minimumJumpsToReachEnd(a, low + i, high), minSteps);
        }

        if (minSteps == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return 1 + minSteps;
        }
    }
}
