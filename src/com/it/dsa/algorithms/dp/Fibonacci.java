package com.it.dsa.algorithms.dp;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {

        //0 1 1 2 3 5 8 13 21 34
        //10th fib number
        int n = 10;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(solveByMemoization(n - 1, dp));
        System.out.println(solveByTabulation(n));
        System.out.println(solveByTabulationWithSpaceOpt(n));

    }

    /*
    Top down approach
    TC:- O(N)
    SC:- O(2N) (N for recursion stack space, N for dp array)
     */
    public static int solveByMemoization(int n, int[] dp) {
        if (n <= 1) return n;

        if (dp[n] != -1) return dp[n];

        int val = solveByMemoization(n - 1, dp) + solveByMemoization(n - 2, dp);
        dp[n] = val;
        return val;
    }

    /*
    TC: O(N)
    SC: O(N)
     */
    public static int solveByTabulation(int n) {

        int[] dp = new int[n];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /*
    TC: O(N)
    TC: O(1)
     */
    public static int solveByTabulationWithSpaceOpt(int n) {

        int secondPrevious = 0;
        int previous = 1;

        for (int i = 2; i < n; i++) {
            int currVal = secondPrevious + previous;
            secondPrevious = previous;
            previous = currVal;
        }
        return previous;
    }

}
