package com.it.problem_solve.leetcode.others;


import java.util.Arrays;

//96. Unique Binary Search Trees
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {

        System.out.println(solveByRec(3));
    }

    public static int solveByMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solveByMemo(n, memo);
    }

    public static int solveByMemo(int n, int[] memo) {

        if (n == 1 || n == 0) return 1;

        if (memo[n] != -1) return memo[n];

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int left = solveByMemo(i - 1, memo);
            int right = solveByMemo(n - i, memo);
            ans = ans + (left * right);
        }

        memo[n] = ans;
        return ans;
    }

    public static int solveByTabulation(int n) {
        int[] dp = new int[n + 1];
        // Base cases
        dp[0] = 1;  // empty tree
        dp[1] = 1;  // single node

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {

                int left = root - 1;
                int right = nodes - root;

                total += dp[left] * dp[right];
            }
            dp[nodes] = total;
        }
        return dp[n];
    }


    public static int solveByRec(int n) {

        if (n == 1 || n == 0) return 1;

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int left = solveByRec(i - 1);
            int right = solveByRec(n - i);
            ans = ans + (left * right);
        }

        return ans;
    }

}
