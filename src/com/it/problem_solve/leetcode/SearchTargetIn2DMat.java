package com.it.problem_solve.leetcode;

public class SearchTargetIn2DMat {

    public static void main(String[] args) {

        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        int[] n = {0, 1, 2, 3, 4, 5};

        int l = 0;
        int r = n.length - 1;
        int mid = 0;
        int t = 3;


        System.out.println(solve(mat, 3));
    }

    public static boolean solve(int[][] mat, int target) {

        int rows = mat.length;
        int cols = mat[0].length;

        int mid = Integer.MIN_VALUE;
        int top = 0;
        int bot = rows - 1;

        if (target < mat[0][0] && target > mat[rows - 1][cols - 1]) return false;

        while (top <= bot) {
            mid = (top + bot) / 2;
            if (target < mat[mid][0]) {
                bot = mid - 1;
            } else if (target >= mat[mid][0] && target <= mat[mid][cols - 1]) {
                break;
            } else {
                top = mid + 1;
            }
        }

        if (top > bot) return false;

        int targetRow = mid;
        int l = 0;
        int r = cols - 1;

        mid = Integer.MIN_VALUE;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target < mat[targetRow][mid]) {
                r = mid - 1;
            } else if (target > mat[targetRow][mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        int targetCol = mid;
        if (mat[targetRow][targetCol] == target) {
            return true;
        }
        return false;
    }
}
