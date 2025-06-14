package com.it.dsa.algorithms.binarysearch;

//74. Search a 2D Matrix
public class SearchTargetIn2DMat {

    public static void main(String[] args) {

        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        int[] n = {0, 1, 2, 3, 4, 5};

        int l = 0;
        int r = n.length - 1;
        int mid = 0;
        int t = 3;


        System.out.println(solveByBinarySearch1(mat, 3));
        System.out.println(solveByBinarySearch2(mat, 3));
    }

    /*
    Since matrix is sorted treat a single array index from 0 to m*n-1.
    extract coordinate from index
     */
    public static boolean solveByBinarySearch1(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int r = mid / n; // gives row
            int c = mid % n; // gives column

            if (mat[r][c] == target) return true;

            if (mat[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean solveByBinarySearch2(int[][] mat, int target) {

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
