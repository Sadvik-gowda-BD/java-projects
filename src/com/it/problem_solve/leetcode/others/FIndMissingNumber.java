package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
 */
public class FIndMissingNumber {

    public static void main(String[] args) {

        //TODO: fix bug
        int[] arr = {2, 3, -7, 6, 8, 1, -10, 15};
        System.out.println(getMissingNumber1(arr));
        System.out.println(solution2(arr));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tSum = (n)*(n+1)/2;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        return tSum - sum;
    }

    public static int solution2(int[] A) {
        // Implement your solution here
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            int ele = A[i];
            if (ele <= 0) {
                continue;
            }
            int nextEle = ele + 1;
            if (A[i + 1] != nextEle || A[i + 1] != ele) {
                return nextEle;
            }
        }

        if (A[A.length - 1] < 0) {
            return 1;
        }
        return A[A.length - 1]++;
    }

    private static int getMissingNumber1(int[] arr) {
        int n = arr.length;

        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }

        int N = maxElement + 1;
        boolean[] present = new boolean[N];

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                present[arr[i]] = true;
            }
        }

        for (int i = 1; i < N; i++) {
            if (!present[i]) {
                return i;
            }
            return N + 1;
        }
        return 0;
    }
}
