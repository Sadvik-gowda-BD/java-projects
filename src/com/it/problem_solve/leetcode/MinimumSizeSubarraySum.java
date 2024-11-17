package com.it.problem_solve.leetcode;

/*
209. Minimum Size Subarray Sum

 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int target = 11;
        int[] nums = {2,12,13,12,13,13,9};

        int result = solve(target, nums);

        System.out.println(result);
    }

    private static int solve(int target, int[] nums) {
        int l = 0;
        int r = 0;

        int sum = nums[0];
        int minLen = Integer.MAX_VALUE;
        while (l <= r) {
            if (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                System.out.println("L= "+l+" R ="+r +" len="+ (r-l+1));
                sum -= nums[l];
                l++;
            } else {
                r++;
                if(r>= nums.length){
                    break;
                }
                sum += nums[r];

            }
        }
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
}
