package com.it.problem_solve.leetcode.others;


import java.util.Arrays;

//3355. Zero Array Transformation I
public class ZeroArrayTransformationI {

    public static void main(String[] args) {
        int[] n1 = {1, 0, 1};
        int[][] q1 = {{0, 2}};

        System.out.println(solveByOptimize(n1, q1));
    }

    private static boolean solveByOptimize(int[] nums, int[][] queries) {

        int[] rangeOccurrence = new int[nums.length + 1];

        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            rangeOccurrence[left] += 1;
            rangeOccurrence[right+1] -= 1;
        }

        int[] numOfOperation = new int[nums.length];
        int currOp = 0;
        for (int i = 0; i < nums.length; i++) {
            currOp += rangeOccurrence[i];
            numOfOperation[i] = currOp;
        }


        for (int i = 0; i < nums.length; i++) {
            if (numOfOperation[i] < nums[i]) return false;
        }
        return true;
    }


    public static boolean solveByBruteforce(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            for (int i = q[0]; i <= q[1]; i++) {
                if (nums[i] > 0) {
                    nums[i]--;
                }
            }
        }
        for (int num : nums) {
            if (num > 0) return false;
        }
        return true;
    }
}
