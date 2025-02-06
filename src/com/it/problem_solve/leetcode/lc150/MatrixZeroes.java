package com.it.problem_solve.leetcode.lc150;

import com.it.problem_solve.util.PrintArray;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatrixZeroes {

    public static void main(String[] args) {

        int[][] mat1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] mat2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        solve(mat1);
        solve(mat2);

        PrintArray.printArray(mat1);
        PrintArray.printArray(mat2);
    }

    private static void solve(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    rowSet.add(r);
                    colSet.add(c);
                }
            }
        }

        for (int r : rowSet) {
            fillRow(r, cols, mat);
        }

        for (int c : colSet) {
            fillCol(c, rows, mat);
        }
    }

    private static void fillRow(int r, int cols, int[][] mat) {
        for (int c = 0; c < cols; c++) {
            mat[r][c] = 0;
        }
    }

    private static void fillCol(int c, int rows, int[][] mat) {
        for (int r = 0; r < rows; r++) {
            mat[r][c] = 0;
        }
    }


}
