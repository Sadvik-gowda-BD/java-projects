package com.it.problem_solve.leetcode;


//162. Find Peak Element
public class FindPeakElement {

    public static void main(String[] args) {

    }


    public static int solve(int[] nums) {
        int r = nums.length - 1;
        int l = 0;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;

            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
