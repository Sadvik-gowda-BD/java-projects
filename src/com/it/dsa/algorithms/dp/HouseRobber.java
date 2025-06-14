package com.it.dsa.algorithms.dp;

//198. House Robber
public class HouseRobber {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 1};
        int[] a2 = {2, 7, 9, 3, 1};
        int[] a3 = {20, 40};

        System.out.println("Solve by bruteforce");
        System.out.println(solveByBF(a1));
        System.out.println(solveByBF(a2));
        System.out.println(solveByBF(a3));

        System.out.println("Solve by Tabulation");
        System.out.println(solveByTabulation(a1));
        System.out.println(solveByTabulation(a2));
        System.out.println(solveByTabulation(a3));
    }

    public static int solveByBF(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return solveByBF(nums, nums.length - 1);
    }

    public static int solveByBF(int[] nums, int ind) {

        if (ind == 0) return nums[ind];
        if (ind < 0) return 0;

        int includePreHouse = solveByBF(nums, ind - 1);
        int includeCurrHose = solveByBF(nums, ind - 2) + nums[ind];

        return Math.max(includePreHouse, includeCurrHose);
    }

    public static int solveByTabulation(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
