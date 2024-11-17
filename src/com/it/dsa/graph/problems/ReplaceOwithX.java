package com.it.dsa.graph.problems;

import java.util.Arrays;

//You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
public class ReplaceOwithX {

    public static void main(String[] args) {

        char[][] mat1 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        char[][] mat2 = {
                {'O', 'O', '0'},
                {'O', 'O', '0'},
                {'O', 'O', '0'}
        };

        solve(mat2);

        for (char[] ch : mat2) {
            System.out.println(Arrays.toString(ch));
        }
    }

    private static void solve(char[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (mat[i][j] == 'O' && !vis[i][j]) {
                        dfs(mat, vis, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 'O' && !vis[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] mat, boolean[][] vis, int r, int c) {

        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length || vis[r][c] || mat[r][c] == 'X') {
            return;
        }

        vis[r][c] = true;
        dfs(mat, vis, r - 1, c);
        dfs(mat, vis, r + 1, c);
        dfs(mat, vis, r, c - 1);
        dfs(mat, vis, r, c + 1);
    }
}
