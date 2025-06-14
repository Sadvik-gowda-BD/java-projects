package com.it.dsa.algorithms.dp;

//70. Climbing Stairs
public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(solveByTabulation(2));
        System.out.println(solveByTabulation(3));

    }

    public static int solveByBruteforce(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return solveByBruteforce(n - 1) + solveByBruteforce(n - 2);
    }

    public static int solveByMemo(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        solveByMemo(n, dp);

        return dp[n];
    }

    public static int solveByMemo(int n, int[] dp) {

        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) return dp[n];

        int val = solveByMemo(n - 1, dp) + solveByMemo(n - 2, dp);
        dp[n] = val;
        return dp[n];
    }

    public static int solveByTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int solveByTabulationSpaceOpt(int n) {
        int pre2 = 1;
        int pre1 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = pre1 + pre2;
            pre2=pre1;
            pre1 = curr;
        }
        return pre1;
    }
}
