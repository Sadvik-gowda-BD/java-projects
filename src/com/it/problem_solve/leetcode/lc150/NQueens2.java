package com.it.problem_solve.leetcode.lc150;


//52. N-Queens II
public class NQueens2 {

    private static int count = 0;

    public static void main(String[] args) {

        int res = solve(4);
        System.out.println(res);

    }

    private static int solve(int n) {

        boolean[][] board = new boolean[n][n];

        return solve2(board, 0, 0, n);
//        return count;
    }

    //With class count variable
    private static void solve(boolean[][] board, int row, int curr, int n) {

        if (n == curr) {
            count++;
            return;
        }

        for (int i = row; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean canPlace = canPlace(board, i, j);
                if (canPlace) {
                    board[i][j] = true;
                    solve(board, i + 1, curr + 1, n);
                    board[i][j] = false;
                }
            }
            return;
        }
    }

    //with return type int
    private static int solve2(boolean[][] board, int row, int curr, int n) {

        if (n == curr) {
            return 1;
        }

        int res = 0;
        for (int i = row; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean canPlace = canPlace(board, i, j);
                if (canPlace) {
                    board[i][j] = true;
                    res += solve2(board, i + 1, curr + 1, n);
                    board[i][j] = false;
                }
            }
            return res;
        }

        return 0;
    }


    private static boolean canPlace(boolean[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }


        int dRow = row;
        int dCol = col;
        while (dRow >= 0 && dCol >= 0) {
            if (board[dRow][dCol]) {
                return false;
            }
            dRow--;
            dCol--;
        }

        dRow = row;
        dCol = col;
        while (dRow >= 0 && dCol < board.length) {
            if (board[dRow][dCol]) {
                return false;
            }
            dRow--;
            dCol++;
        }
        return true;
    }
}