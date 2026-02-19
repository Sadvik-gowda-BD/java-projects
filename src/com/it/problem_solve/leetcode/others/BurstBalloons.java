package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

//312. Burst Balloons
public class BurstBalloons {

    public static void main(String[] args) {

        int[] arr = {3, 1, 5, 8};
        int[] arr2 = {1, 5};

        System.out.println(solve(arr));
    }


    /*
    🔥 Why This Trick works
If we tried to burst first:
Neighbors keep changing → complicated.

If we burst last:
Neighbors are fixed → easy formula.
That’s why we reverse thinking.
     */

    private static int solve(int[] arr) {

        int len = arr.length;
        int[] arrWithBoundry = new int[len + 2];
        arrWithBoundry[0] = 1;
        arrWithBoundry[len + 1] = 1;

        int[][] memo = new int[arrWithBoundry.length][arrWithBoundry.length];
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));

        for (int i = 0; i < len; i++) {
            arrWithBoundry[i + 1] = arr[i];
        }
        return solveByMemo(arrWithBoundry, 0, len + 1, memo);
    }

    private static int solveByMemo(int[] arr, int left, int right, int[][] memo) {
        // base case: no balloon between
        if (right - left <= 1) {
            return 0;
        }

        if (memo[left][right] != -1) return memo[left][right];

        int max = 0;
        // try every balloon as last burst
        //max coins by bursting balloons between left and right (exclusive)
        for (int k = left + 1; k < right; k++) {
            int val = solveByMemo(arr, left, k, memo)
                    + solveByMemo(arr, k, right, memo)
                    + (arr[left] * arr[k] * arr[right]);
            max = Math.max(max, val);
        }

        memo[left][right] = max;
        return max;
    }

    private static int solveByRec(int[] arr, int left, int right) {
        // base case: no balloon between
        if (right - left <= 1) {
            return 0;
        }

        int max = 0;
        // try every balloon as last burst
        //max coins by bursting balloons between left and right (exclusive)
        for (int k = left + 1; k < right; k++) {
            int val = solveByRec(arr, left, k)
                    + solveByRec(arr, k, right)
                    + (arr[left] * arr[k] * arr[right]);
            max = Math.max(max, val);
        }

        return max;
    }


}
