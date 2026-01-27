package com.it.problem_solve.leetcode;


import java.util.Arrays;
import java.util.Stack;

//503. Next Greater Element II
public class NextGreaterElementII {

    public static void main(String[] args) {

    }


    public static int[] solve(int[] nums) {

        int len = nums.length;
        int[] ans = new int[len];

        Arrays.fill(ans, -1);

        Stack<Integer> monotonicStack = new Stack<>();

        for (int i = len-2; i >=0; i--) {
            monotonicStack.push(nums[i]);
        }

        for (int i = len - 1; i >= 0; i--) {

            while (!monotonicStack.isEmpty()) {

                int val = monotonicStack.peek();

                if (val > nums[i]) {
                    ans[i] = val;
                    break;
                }
                monotonicStack.pop();
            }
            monotonicStack.push(nums[i]);
        }

        return ans;
    }

}
