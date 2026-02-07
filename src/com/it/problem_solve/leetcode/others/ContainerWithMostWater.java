package com.it.problem_solve.leetcode.others;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.
 */
public class ContainerWithMostWater {


    public static void main(String[] args) {

        int[] arr= {1,8,6,2,5,4,8,3,7};

        System.out.println(solve(arr));
    }

    private static int solve(int[] heights) {

        int maxVal = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            int val = (right - left) * minHeight;
            maxVal = Math.max(maxVal, val);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxVal;
    }
}
