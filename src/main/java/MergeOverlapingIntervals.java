/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.Arrays;

public class MergeOverlapingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3},
                {2, 6},
                {8, 10},

                {9, 18},
                {19, 22}};

//        mergeSort(intervals, 0, intervals.length - 1);

        merge(intervals);
        System.out.println(Arrays.toString(intervals));
    }


    public static int[][] merge(int[][] intervals) {

        mergeSort(intervals, intervals.length - 1, intervals.length - 1);
        int low = 0, high = intervals[0].length - 1;

        int[][] result = new int[intervals.length][intervals.length];
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];

        int resultIndex = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (result[resultIndex - 1][0] <= intervals[i][0] && intervals[i][0] <= result[resultIndex - 1][1]) {
                result[resultIndex - 1][0] = Math.min(result[resultIndex - 1][0], intervals[i][0]);
                result[resultIndex - 1][1] = Math.max(result[resultIndex - 1][1], intervals[i][1]);
            } else {
                result[resultIndex][0] = intervals[i][0];
                result[resultIndex][1] = intervals[i][1];
                resultIndex++;
            }
        }
        return result;

    }


    private static void mergeSort(int[][] a, int low, int high) {

        if (low > high)
            return;

        if (low == high)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        merge(a, low, mid, high);
    }

    private static void merge(int[][] a, int low, int mid, int high) {
        int[][] tmp = new int[a.length][2];
        int tmpIndex = 0;
        int first = low, second = mid + 1;

        while (first <= mid && second <= high) {

            if (a[first][0] <= a[second][0]) {
                tmp[tmpIndex][0] = a[first][0];
                tmp[tmpIndex][1] = a[first][1];

                tmpIndex++;
                first++;
            } else {

                tmp[tmpIndex][0] = a[second][0];
                tmp[tmpIndex][1] = a[second][1];
                tmpIndex++;
                second++;
            }
        }
        if (first <= mid) {
            while (first <= mid) {
                tmp[tmpIndex][0] = a[first][0];
                tmp[tmpIndex][1] = a[first][1];

                tmpIndex++;
                first++;
            }
        }

        if (second <= high) {
            while (second <= high) {

                tmp[tmpIndex][0] = a[second][0];
                tmp[tmpIndex][1] = a[second][1];
                tmpIndex++;
                second++;
            }
        }

        tmpIndex = 0;
        while (low <= high) {
            a[low][0] = tmp[tmpIndex][0];
            a[low][1] = tmp[tmpIndex][1];

            low++;
            tmpIndex++;
        }

    }


}
