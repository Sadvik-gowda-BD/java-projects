package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
51. N-Queens
 */
public class NQueens {


    //TODO: fix issue
    public static void main(String[] args) {

        int n = 4;

        List<List<String>> ls = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int[][] arr = new int[n][n];
            boolean valid = solve(arr, i);
            if (valid) {
                add(ls, arr, n);
            }
        }

        System.out.println("Possible solutions are:");

        for (List<String> lst : ls){
            System.out.println(lst);
        }

    }

    private static void add(List<List<String>> ls, int[][] arr, int n) {

        System.out.println("call");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder st = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    st.append("Q");
                } else {
                    st.append(".");
                }
            }
            list.add(st.toString());
        }
        ls.add(list);
    }

    private static boolean solve(int[][] grid, int col) {

        if (col >= grid.length) {
            return true;
        }

        for (int r = 0; r < grid.length; r++) {

            if (canPlace(grid, r, col)) {
                grid[r][col] = 1;
                boolean res = solve(grid, col + 1);
                if (res) {
                    return true;
                }
                grid[r][col] = 0;
            }
        }
        return false;
    }

    private static boolean canPlace(int[][] grid, int row, int col) {

        int N = grid.length;

        for (int c = 0; c < col; c++) {
            if (grid[row][c] == 1) {
                return false;
            }
        }

        int r, c;

        for (r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (grid[r][c] == 1) {
                return false;
            }
        }

        for (r = row, c = col; r < N && c >= 0; r++, c--) {
            if (grid[r][c] == 1) {
                return false;
            }
        }


        return true;

    }
}
