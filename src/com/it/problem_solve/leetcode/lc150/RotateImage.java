package com.it.problem_solve.leetcode.lc150;

public class RotateImage {

    public static void main(String[] args) {

    }

    public static void solve(int[][] mat) {
        int len = mat.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int r = 0; r < len; r++) {
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int temp = mat[r][left];
                mat[r][left] = mat[r][right];
                mat[r][right] = temp;
                left++;
                right--;
            }
        }
    }
}
