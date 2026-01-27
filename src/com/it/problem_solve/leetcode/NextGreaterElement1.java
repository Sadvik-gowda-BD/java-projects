package com.it.problem_solve.leetcode;


import java.util.HashMap;
import java.util.Stack;

//496. Next Greater Element I
public class NextGreaterElement1 {

    public static void main(String[] args) {

    }

    public static int[] solve(int[] nums1, int[] nums2) {

        int len = nums2.length;
        int[] ans = new int[nums1.length];
        Stack<Integer> monotonicStack = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = len - 1; i >= 0; i--) {

            while (!monotonicStack.isEmpty()) {

                int val = monotonicStack.peek();

                if (val > nums2[i]) {
                    hm.put(nums2[i], val);
                    break;
                }
                monotonicStack.pop();
            }

            if (monotonicStack.isEmpty()) {
                hm.put(nums2[i], -1);
            }
            monotonicStack.push(nums2[i]);
        }

        for (int i=0; i< nums1.length; i++){

            ans[i] = hm.get(nums1[i]);
        }

        return ans;
    }
}
