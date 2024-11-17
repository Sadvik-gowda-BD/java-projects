package com.it.dsa.graph.problems;

public class NoOfEnclaves {

    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int res = solve(mat);

        System.out.println(res);
    }

    private static int solve(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && !vis[i][j] && isBorder(mat, i, j)) {
                    dfs(mat, i, j, vis);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] mat, int i, int j, boolean[][] vis) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] || mat[i][j] == 0) {
            return;
        }

        vis[i][j] = true;
        dfs(mat, i - 1, j, vis);
        dfs(mat, i + 1, j, vis);
        dfs(mat, i, j - 1, vis);
        dfs(mat, i, j + 1, vis);
    }


    private static boolean isBorder(int[][] mat, int i, int j) {
        return i == 0 || j == 0 || i == mat.length - 1 || j == mat[0].length-1;
    }
}
