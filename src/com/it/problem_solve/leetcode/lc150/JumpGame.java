package com.it.problem_solve.leetcode.lc150;

/*
55. Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
array represents your maximum jump length at that position.
 */
public class JumpGame {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {1, 2};

        System.out.println(canJump(nums));
        System.out.println(canJump(nums2));
        System.out.println(canJump(nums3));
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int lastJump = 0;
        int maxReachable = nums[0];

        if (maxReachable >= len || len == 1) {
            return true;
        }

        while (lastJump < len) {
            int steps = nums[lastJump];
            int maxReachInd = 0;
            if (steps == 0) {
                return false;
            }

            for (int st = 1; st <= steps; st++) {
                int currIndex = lastJump + st;
                int currReachable = currIndex + nums[currIndex];
                if (maxReachable <= currReachable) {
                    maxReachable = currReachable;
                    maxReachInd = currIndex;
                }
            }

            if (maxReachable >= len - 1) {
                return true;
            }
            lastJump = maxReachInd;
        }
        return true;
    }

    public boolean simpleSoln(int[] nums) {
        int reachable = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
