package com.it.problem_solve.leetcode.lc150;


//918. Maximum Sum Circular Subarray
public class MaxSumCircularSubArray {

    public static void main(String[] args) {
        int[] arr1 = {-3, -2, -3};

        System.out.println(solve(arr1));
        System.out.println(bf(arr1));
    }

    private static int solve(int[] nums) {

        int maxSum = nums[0];
        int minSum = nums[0];

        int currMax = 0;
        int currMin = 0;
        int totalSum = 0;

        for (int num : nums) {

            // Normal Kadane's
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(currMax, maxSum);

            // Kadane's but with min to find minimum subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(currMin, minSum);

            totalSum += num;
        }

        if (totalSum == minSum) return maxSum;

        int circularSum = totalSum - minSum;
        return Math.max(maxSum, circularSum);

    }


    public static int bf(int[] arr) {

        int len = arr.length;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                int ind = (i + j) % len;

                if (sum + arr[ind] > 0) {
                    sum += arr[ind];
                    ans = Math.max(ans, sum);
                } else {
                    ans = Math.max(ans, arr[ind]);
                    sum = 0;
                }
            }

        }
        return ans;
    }

}
