package com.it.problem_solve.leetcode.others2;


import com.it.problem_solve.leetcode.others.ListNode;

//1004. Max Consecutive Ones III
public class MaxConsecutiveOnes3 {

    public static void main(String[] args) {

    }

    private static int solve(int[] arr) {
        int len = arr.length;

        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + arr[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] + arr[i + 1];
        }

        for (int i = 0; i < len; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int solve2(int[] arr) {
        int len = arr.length;

        int rightSum = 0;
        int leftSum = 0;

        for (int num : arr) {
            rightSum += num;
        }

        for (int i = 0; i < len; i++) {
            rightSum -= arr[i];

            if (leftSum == rightSum) return i;
            leftSum += arr[i];

        }

        return -1;
    }


}
