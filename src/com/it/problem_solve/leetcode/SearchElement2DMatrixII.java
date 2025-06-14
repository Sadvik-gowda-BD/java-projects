package com.it.problem_solve.leetcode;

/*
240. Search a 2D Matrix II
 */
public class SearchElement2DMatrixII {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 30;

        System.out.println(solve(matrix, target));
    }

    /*
    We start search the matrix from top right corner, initialize the current position to top right corner, if the target
    is greater than the value in current position, then the target can not be in entire row of current position because
    the row is sorted, if the target is less than the value in current position, then the target can not in the entire
    column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).
     */
    private static boolean solve(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int col = n - 1;
        int row = 0;
        while (row < m && col >= 0) {

            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }


    private static boolean bruteFore(int[][] mat, int t) {

        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == t) {
                    return true;
                }
            }
        }
        return false;
    }
}
