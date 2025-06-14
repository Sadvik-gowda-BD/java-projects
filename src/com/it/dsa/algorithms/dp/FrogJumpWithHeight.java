package com.it.dsa.algorithms.dp;


//GFG

import java.util.Arrays;

/*
Given an integer array height[] where height[i] represents the height of the i-th stair, a frog starts from the first stair
and wants to reach the top. From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th
stair. The cost of a jump is the absolute difference in height between the two stairs. Determine the minimum total cost required for the frog to reach the top.
 */
public class FrogJumpWithHeight {

    public static void main(String[] args) {

        int[] arr = {20, 30, 40, 20};
        int[] arr2 = {30, 20, 50, 10, 40};

        System.out.println("Solve by bruteforce");
        System.out.println(solveByBF(arr, arr.length - 1));
        System.out.println(solveByBF(arr2, arr2.length - 1));

        System.out.println("Solve by memoization");
        System.out.println(solveByMemo(arr));
        System.out.println(solveByMemo(arr2));

        System.out.println("Solve by solveByTabulation");
        System.out.println(solveByTabulation(arr));
        System.out.println(solveByTabulation(arr2));


    }

    public static int solveByBF(int[] heights, int ind) {

        if (ind <= 0) return 0;
        if (ind == 1) return Math.abs(heights[ind] - heights[ind - 1]);

        int step1 = solveByBF(heights, ind - 1) + Math.abs(heights[ind] - heights[ind - 1]);
        int step2 = solveByBF(heights, ind - 2) + Math.abs(heights[ind] - heights[ind - 2]);
        return Math.min(step1, step2);
    }

    public static int solveByMemo(int[] heights) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        return solveByMemo(heights, dp, heights.length - 1);


    }

    public static int solveByMemo(int[] heights, int[] dp, int ind) {
        if (ind <= 0) return 0;
        if (ind == 1) return Math.abs(heights[ind] - heights[ind - 1]);

        if (dp[ind] != -1) return dp[ind];
        int step1 = solveByMemo(heights, dp, ind - 1) + Math.abs(heights[ind] - heights[ind - 1]);
        int step2 = solveByMemo(heights, dp, ind - 2) + Math.abs(heights[ind] - heights[ind - 2]);
        int ans = Math.min(step1, step2);
        dp[ind] = ans;
        return ans;
    }

    public static int solveByTabulation(int[] heights) {
        int len = heights.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = Math.abs(heights[0] - heights[1]);

        for (int i = 2; i < len; i++) {
            int step2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            int step1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            dp[i] = Math.min(step1, step2);
        }
        return dp[len - 1];
    }
}
