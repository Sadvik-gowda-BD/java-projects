package com.it.problem_solve.leetcode;

import java.util.Arrays;

//59. Spiral Matrix II
public class SpiralMatrixII {

    public static void main(String[] args) {

        int[][] ans = solve(3);

        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] solve(int n) {

        int[][] arr = new int[n][n];
        int num = 1;

        int topRow = 0;
        int botRow = n - 1;
        int leftCol = 0;
        int rightCol = n - 1;

        while (num <= (n * n)) {

            for (int i = leftCol; i <= rightCol; i++) {
                arr[topRow][i] = num;
                num++;
            }
            topRow++;

            for (int i = topRow; i <= botRow; i++) {
                arr[i][rightCol] = num;
                num++;
            }
            rightCol--;

            for (int i = rightCol; i >= leftCol; i--) {
                arr[botRow][i] = num;
                num++;
            }
            botRow--;

            for (int i = botRow; i >= topRow; i--) {
                arr[i][leftCol] = num;
                num++;
            }
            leftCol++;

        }
        return arr;
    }
}
