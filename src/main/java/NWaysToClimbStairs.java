package main.java;

public class NWaysToClimbStairs {

    public static void main(String[] args) {

        int totalHeightOfStair = 5; // Total height of stairs
        int[] steps = {1, 2, 5}; // Different kind of steps available

        NwayToClimbStairs(new int[totalHeightOfStair], 0, steps, totalHeightOfStair);
    }

    private static void NwayToClimbStairs(int[] paths, int upperIndex, int[] steps, int totalSum) {

        if (totalSum == 0) {
            for (int i = 0; i <= upperIndex - 1; i++) {
                System.out.print(paths[i] + " , ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < steps.length; i++) {
            int stepSize = steps[i];
            int remainingSum = totalSum - stepSize;
            if (remainingSum >= 0 && upperIndex < paths.length) {
                paths[upperIndex] = stepSize;
                NwayToClimbStairs(paths, upperIndex + 1, steps, remainingSum);
            }
        }

    }
}
