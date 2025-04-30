package com.it.problem_solve.leetcode;

import java.util.Arrays;

//1283. Find the Smallest Divisor Given a Threshold
public class SmallestDivisor {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 5, 9};
        int th1 = 6;

        System.out.println(solve(nums1, th1));

        int[] nums2 = {44, 22, 33, 11, 1};
        int th2 = 5;

        System.out.println(solve(nums2, th2));
    }

    /*

    answer between : 1 to (max num in  arr)
    if divisor n's sum > threshold - then move right side
     */
    public static int solve(int[] nums, int threshold) {

        int low = 1;
        int high = Arrays.stream(nums).max().orElse(0);

        if (threshold == nums.length) {
            return high;
        }
        int mid = 0;
        //stop when s == e
        while (low < high) {
            int sum = 0;
            mid = (low + high) / 2;
            for (int num : nums) {
                sum += (int) Math.ceil((double) num / mid);
            }

            //if sum is > th then definitely we need to go for next larger divisor
            if (sum > threshold) {
                low = mid + 1;
            } else {
                //mid or number less than mid can be the answer.
                high = mid;
            }
        }
        return low;
    }

    public static int solve2(int[] nums, int th) {

        int s = 1;
        int e = Arrays.stream(nums).max().orElse(0);

        if (th == nums.length) {
            return e;
        }


        for (int d = s; d <= e; d++) {
            int sum = 0;
            for (int num : nums) {
                sum += (int) Math.ceil((double) num / d);
            }

            if (sum <= th) {
                return d;
            }
        }
        return 0;
    }
}
