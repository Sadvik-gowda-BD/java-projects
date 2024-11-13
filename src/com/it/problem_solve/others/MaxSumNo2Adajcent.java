package com.it.problem_solve.others;


import java.util.Arrays;

//DP
public class MaxSumNo2Adajcent {

    public static void main(String[] args) {

        int[] arr = {3, 2, 5, 10, 7};

        solve(arr);
    }

    private static int solve(int[] arr) {

        int len = arr.length;
        int[] dp = new int[len];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);


        for (int i = 2; i < len; i++) {
            int n1 = arr[i] + dp[i - 2];
            int n2 = dp[i - 1];
            dp[i] = Math.max(n1, n2);
        }

        System.out.println(Arrays.toString(dp));

        return arr[len - 1];
    }
}
