package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

public class TwoSumSorted {

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] res = solve(arr, target);

        System.out.println(Arrays.toString(res));

    }

    public static int[] solve(int[] arr, int target) {

        int[] result = new int[2];
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        result[0]++;
        result[1]++;
        return result;
    }
}
