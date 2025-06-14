package com.it.problem_solve.leetcode;


import java.util.ArrayList;
import java.util.List;

//417. Pacific Atlantic Water Flow
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        int[][] heights2 = {{1}};

        System.out.println(solve(heights));
        System.out.println(solve(heights2));

    }

    public static List<List<Integer>> solve(int[][] mat) {
        List<List<Integer>> res = new ArrayList<>();

        int rows = mat.length;
        int cols = mat[0].length;

        Pair[][] reachMat = new Pair[rows][cols];

        boolean[][] pacificBool = new boolean[rows][cols];
        boolean[][] atlanticBool = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (r == 0 || c == 0) {
                    dfs(rows, cols, r, c, reachMat, pacificBool, mat);
                }
                if (r == rows - 1 || c == cols - 1) {
                    dfs(rows, cols, r, c, reachMat, atlanticBool, mat);
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificBool[r][c] && atlanticBool[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    public static void dfs(int rows, int cols, int r, int c, Pair[][] pairMat, boolean[][] vis, int[][] mat) {

        if (r < 0 || c < 0 || r >= rows || c >= cols || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        if ((r + 1) < rows && mat[r + 1][c] >= mat[r][c]) {
            dfs(rows, cols, r + 1, c, pairMat, vis, mat);
        }

        if ((c + 1) < cols && mat[r][c + 1] >= mat[r][c]) {
            dfs(rows, cols, r, c + 1, pairMat, vis, mat);
        }

        if ((r - 1) >= 0 && mat[r - 1][c] >= mat[r][c]) {
            dfs(rows, cols, r - 1, c, pairMat, vis, mat);
        }

        if ((c - 1) >= 0 && mat[r][c - 1] >= mat[r][c]) {
            dfs(rows, cols, r, c - 1, pairMat, vis, mat);
        }
    }

}
