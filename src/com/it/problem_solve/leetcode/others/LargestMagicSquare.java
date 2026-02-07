package com.it.problem_solve.leetcode.others;

public class LargestMagicSquare {

    public static void main(String[] args) {

    }


    public static int solve(int[][] mat) {

        int tRows = mat.length;
        int tCols = mat[0].length;

        int[][] rps = new int[tRows][tCols];
        int[][] cps = new int[tRows][tCols];

        int currAns = 0;

        for (int i = 0; i < tRows; i++) {
            int rowSum = 0;
            for (int j = 0; j < tCols; j++) {
                rowSum += mat[i][j];
                rps[i][j] = rowSum;
            }
        }

        for (int i = 0; i < tCols; i++) {
            int colSum = 0;
            for (int j = 0; j < tRows; j++) {
                colSum += mat[j][i];
                cps[j][j] = colSum;
            }
        }

        for (int i = 0; i < tRows; i++) {
            for (int j = 0; j < tCols; j++) {
                int preRow = i > 0 ? mat[i - 1][j] : 0;
                int preCol = j > 0 ? mat[i][j - 1] : 0;


            }
        }

        return 0;
    }

    private int check(int startI, int startJ, int[][] mat) {
        int tRows = mat.length;
        int tCols = mat[0].length;

        int preRow = startI > 0 ? mat[startI - 1][startJ] : 0;
        int preCol = startJ > 0 ? mat[startI][startJ - 1] : 0;

        int maxInd = Math.min((tRows - startI), (tCols - startJ));
        for (int ind = maxInd; ind >= 0; ind--) {
            int LtoR = mat[startI][startI + ind] - preRow;
            int TtoB = mat[ind][startJ + ind] - preCol;
            if (LtoR == TtoB) {
                for (int i = startI; i <= startI + ind; i--) {
                    if ((mat[i][startJ+ind]- preCol)!= LtoR) break;
                }

                for (int i = startJ; i <= startJ + ind; i--) {
                    if ((mat[i][startJ+ind]- preCol)!= LtoR) break;
                }
            }

        }
        return 0;
    }


}


