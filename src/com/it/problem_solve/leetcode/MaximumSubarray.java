package com.it.problem_solve.leetcode;

//53. Maximum Subarray
public class MaximumSubarray {

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {

        int currSum = 0;
        int ans = Integer.MIN_VALUE;

        for (int num : arr) {
            if ((currSum + num) > 0) {
                currSum += num;
                ans = Math.max(currSum, ans);
            } else {
                ans = Math.max(num, ans);
                currSum = 0;
            }
        }
        return ans;
    }
}
