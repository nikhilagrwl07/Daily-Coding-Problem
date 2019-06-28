package main.java;

/*
A builder is looking to build a row of N houses that can be of K different colors.
He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build
the nth house with kth color, return the minimum cost which achieves this goal.
 */
public class MinimumCostToBuildAllHouses {


    private static final int[][] costLookup = {
            {8, 4, 1},
            {2, 1, 2},
            {10, 0, 6},
            {2, 0, 3}
    };

    public static void main(String[] args) {

        int[] orderOfHouseBuilt = new int[costLookup.length];

        int minimumCost = minimizeCost(0, orderOfHouseBuilt, 0);
        System.out.println(minimumCost);

    }

    private static int minimizeCost(int houseNumber, int[] path, int sum) {

        if (houseNumber > path.length - 1) {
            return sum;
        }

        int minCost = Integer.MAX_VALUE;

        for (int paint = 0; paint < costLookup[0].length; paint++) {

            if (houseNumber == 0 || (houseNumber > 0 && path[houseNumber - 1] != paint)) {
                path[houseNumber] = paint;
                int minCostCal = minimizeCost(houseNumber + 1, path, sum + costLookup[houseNumber][paint]);

                if (minCost > minCostCal) {
                    minCost = minCostCal;
                }
            }
        }
        return minCost;
    }

}
