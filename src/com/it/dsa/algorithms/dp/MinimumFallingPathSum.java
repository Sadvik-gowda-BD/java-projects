package com.it.dsa.algorithms.dp;


//931. Minimum Falling Path Sum
public class MinimumFallingPathSum {

    public static void main(String[] args) {

    }

    public static int solveByDp(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dp = new int[rows][cols];

        for (int c = 0; c < cols; c++) {
            dp[0][c] = mat[0][c];
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int left = Integer.MAX_VALUE, straight, right = Integer.MAX_VALUE;

                if (c - 1 >= 0) left = dp[r - 1][c - 1];
                if (c + 1 < cols) right = dp[r - 1][c + 1];
                straight = dp[r - 1][c];
                dp[r][c] = mat[r][c] + getMin(left, straight, right);
            }

        }

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < cols; c++) {
            ans = Math.min(dp[rows - 1][c], ans);
        }
        return ans;
    }


    public static int solveByBF(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int c = 0; c < cols; c++) {
            int val = solveByBF(matrix, rows - 1, c);
            ans = Math.min(val, ans);
        }
        return ans;
    }

    public static int solveByBF(int[][] mat, int i, int j) {
        if (j >= mat[0].length || j < 0) return Integer.MAX_VALUE;
        if (i == 0) {
            return mat[i][j];
        }

        int left = solveByBF(mat, i - 1, j - 1);
        int straight = solveByBF(mat, i - 1, j);
        int right = solveByBF(mat, i - 1, j + 1);

        return mat[i][j] + getMin(left, straight, right);
    }

    private static int getMin(int n1, int n2, int n3) {
        if (n1 < n2) {
            return Math.min(n1, n3);
        } else {
            return Math.min(n2, n3);
        }
    }


}
