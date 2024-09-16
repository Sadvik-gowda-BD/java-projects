package com.it.logic.leetcode;

import java.util.Arrays;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {2,1,1,4};
        System.out.println(rob(arr));
    }

    public static  int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }else if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for(int i=2; i< nums.length;i++){
            int n1 = dp[i-2]+nums[i];
            int n2 = dp[i-1];
            dp[i] = Math.max(n1, n2);
        }

        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }

}
