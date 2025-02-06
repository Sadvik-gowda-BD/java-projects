package com.it.problem_solve.leetcode.lc150;

import com.it.problem_solve.util.PrintArray;

import java.util.Arrays;

/*
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class GamOfLife {

    public static void main(String[] args) {

        int[][] mat = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        solve(mat);

        PrintArray.printArray(mat);

    }

    private static void solve(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] matCopy = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matCopy[i][j] = mat[i][j];
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int liveCells = getNeighLiveCell(r, c, matCopy);
                if (matCopy[r][c] == 0) {
                    if (liveCells == 3) {
                        mat[r][c] = 1;
                    }
                } else if (liveCells < 2 || liveCells > 3) {
                    mat[r][c] = 0;
                }
            }
        }
    }

    private static int getNeighLiveCell(int row, int col, int[][] mat) {
        int count = 0;

        int rows = mat.length;
        int cols = mat[0].length;

        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }
                int delRow = row + r;
                int delCol = col + c;
                if (isValid(rows, cols, delRow, delCol)) {
                    if (mat[delRow][delCol] == 1) {
                        count++;
                    }
                }

            }
        }
        return count;
    }

    private static boolean isValid(int rows, int cols, int r, int c) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }


}
