package com.it.problem_solve.leetcode.others2;


//1594. Maximum Non Negative Product in a Matrix
public class MaxNonNegativeProduct {

    private static int MOD = 1_000_000_007;

    public static void main(String[] args) {

        int[][] arr = {{2, 3}};
        System.out.println(rec(arr));
        System.out.println(dp(arr));
    }

    private static int dp(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;
        long[][][] dp = new long[rows][cols][2]; //[min, max]

        dp[0][0] = new long[]{arr[0][0], arr[0][0]};

        for (int i = 1; i < rows; i++) {
            long val = ((long) arr[i][0] * dp[i - 1][0][0]);
            dp[i][0][0] = val;
            dp[i][0][1] = val;
        }

        for (int i = 1; i < cols; i++) {
            long val = (long) arr[0][i] * dp[0][i - 1][0];
            dp[0][i][0] = val;
            dp[0][i][1] = val;
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {

                long[] up = dp[i - 1][j];
                long[] left = dp[i][j - 1];

                long upMax = Math.max(up[0], up[1]);
                long upMin = Math.min(up[0], up[1]);

                long leftMax = Math.max(left[0], left[1]);
                long leftMin = Math.min(left[0], left[1]);

                long max = arr[i][j] * Math.max(upMax, leftMax);
                long min = arr[i][j] * Math.min(upMin, leftMin);

                dp[i][j][0] = max;
                dp[i][j][1] = min;
            }
        }

        long max = Math.max(dp[rows - 1][cols - 1][0], dp[rows - 1][cols - 1][1]);
        if (max >= 0) {
            return (int) (max % MOD);
        } else {
            return -1;
        }
    }

    private static int rec(int[][] arr) {

        long[] res = rec(arr, 0, 0);
        long val = Math.max(res[0], res[1]);

        if (val < 0) {
            return -1;
        } else {
            return (int) (val % MOD);
        }
    }


    private static long[] rec(int[][] arr, int i, int j) {

        if (i == arr.length - 1 && j == arr[0].length - 1) return new long[]{arr[i][j], arr[i][j]};

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        if (i + 1 < arr.length) {
            long[] down = rec(arr, i + 1, j);
            long a = arr[i][j] * down[0];
            long b = arr[i][j] * down[1];

            min = Math.min(a, b);
            max = Math.max(a, b);
        }

        if (j + 1 < arr[0].length) {
            long[] right = rec(arr, i, j + 1);
            long a = arr[i][j] * right[0];
            long b = arr[i][j] * right[1];

            min = Math.min(min, Math.min(a, b));
            max = Math.max(max, Math.max(a, b));
        }


        return new long[]{max, min};
    }


}
