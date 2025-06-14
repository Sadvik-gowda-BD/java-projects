package com.it.dsa.algorithms.dp;

import java.util.Arrays;

//Striver tutorial
public class FrogKJumpWithHeight {

    public static void main(String[] args) {

        int[] arr = {20, 30, 40, 20};
        int[] arr2 = {30, 20, 50, 10, 40};

        System.out.println("Solve by bruteforce");
        System.out.println(solveByBF(arr, 2));
        System.out.println(solveByBF(arr2, 2));

        System.out.println("Solve by memo");
        System.out.println(solveByMemo(arr, 2));
        System.out.println(solveByMemo(arr2, 2));

        System.out.println("Solve by tabulation");
        System.out.println(solveByTabulation(arr, 2));
        System.out.println(solveByTabulation(arr2, 2));

    }

    /*
    TC: O(N)*k
     */
    public static int solveByTabulation(int[] heights, int k) {
        int len = heights.length;
        int[] dp = new int[len];

        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                int preInd = i - j;
                if (preInd < 0) break;

                int val = dp[preInd] + Math.abs(heights[i] - heights[preInd]);
                min = Math.min(val, min);
            }
            dp[i] = min;
        }

        return dp[len - 1];
    }

    public static int solveByMemo(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return solveByMemo(heights, k, dp, heights.length - 1);
    }

    public static int solveByMemo(int[] heights, int k, int[] dp, int ind) {
        if (ind == 0) return 0;

        if (dp[ind] != -1) return dp[ind];

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            int pre = ind - j;
            if (pre < 0) break;

            int val = solveByMemo(heights, k, dp, pre) + Math.abs(heights[ind] - heights[pre]);

            min = Math.min(val, min);
        }
        dp[ind] = min;

        return min;
    }

    public static int solveByBF(int[] heights, int k) {
        return solveByBF(heights, k, heights.length - 1);
    }

    public static int solveByBF(int[] heights, int k, int ind) {

        if (ind == 0) return 0;

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            int pre = ind - j;
            if (pre < 0) break;

            int val = solveByBF(heights, k, pre) + Math.abs(heights[ind] - heights[pre]);

            min = Math.min(val, min);
        }

        return min;

    }
}
