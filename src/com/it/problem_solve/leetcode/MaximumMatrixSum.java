package com.it.problem_solve.leetcode;


//1975. Maximum Matrix Sum
public class MaximumMatrixSum {

    public static void main(String[] args) {

    }

    public long solve(int[][] matrix) {

        int min = Integer.MAX_VALUE;
        int negCount = 0;
        long totalSum = 0;

        for (int[] r : matrix) {
            for (int val : r) {
                min = Math.min(min, Math.abs(val));
                totalSum += Math.abs(val);
                if (val < 0) negCount++;
            }
        }

        if (negCount % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - (2L * min);
        }
    }
}
