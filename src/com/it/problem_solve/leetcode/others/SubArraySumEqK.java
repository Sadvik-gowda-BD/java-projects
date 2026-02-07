package com.it.problem_solve.leetcode.others;

/*
Given an array of integers and a target sum, return the length of longest subarray matching target sum.
 */
public class SubArraySumEqK {

    public static void main(String[] args) {

        int[] arr = {1, 4, 1, 2, 6, 3};
        System.out.println(solve(arr, 8));
    }

    private static int solve(int[] arr, int k) {
        int p1 = 0;
        int max = 0;
        while (p1 < arr.length) {
            int sum = 0;
            for (int i = p1; i < arr.length; i++) {
                sum += arr[i];
                if (sum == k) {
                    max = Math.max(max, (i - p1 + 1));
                    break;
                }
                if (sum > k) {
                    break;
                }
            }
            p1++;

        }
        return max;

    }


}
