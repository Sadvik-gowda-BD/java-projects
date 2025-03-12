package com.it.dsa.graph.problems;

public class SurroundedRegions {


    public static void main(String[] args) {

    }

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] vis = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(board, vis, 0, c, rows, cols);
            dfs(board, vis, rows - 1, c, rows, cols);
        }

        for (int r = 0; r < rows; r++) {
            dfs(board, vis, r, 0, rows, cols);
            dfs(board, vis, r, cols - 1, rows, cols);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O' && !vis[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, boolean[][] vis, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == 'X' || vis[r][c]) {
            return;
        }
        vis[r][c] = true;

        dfs(board, vis, r + 1, c, rows, cols);
        dfs(board, vis, r - 1, c, rows, cols);
        dfs(board, vis, r, c + 1, rows, cols);
        dfs(board, vis, r, c - 1, rows, cols);
    }


}
