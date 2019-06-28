package main.java;

public class MaximumSumSubarrayKadane {
    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        largestSumSubarrayKadane(a);
//        System.out.println(largestSumSubarrayKadane);
    }

    private static void largestSumSubarrayKadane(int[] a) {
        if (a == null || a.length == 0)
            return;

        int max_so_far = 0;
        int max_current = 0;
        int start = 0, end = 0;

        for (int i = 0; i < a.length; i++) {
            max_current = max_current + a[i];

            if (max_current < 0) {
                max_current = 0;
                start = i+1;
            } else if (a[i] > 0 && max_so_far < max_current) {
                max_so_far = max_current;
                end = i;

            }
        }
        System.out.println("Maximum sum subarray -> " + max_so_far);

        System.out.print("Subarray -> ");
        for(int i= start;i<=end;i++)
        {
            System.out.print(a[i] + " ");
        }

    }
}
