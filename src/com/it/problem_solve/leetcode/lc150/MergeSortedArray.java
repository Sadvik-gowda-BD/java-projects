package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

/*
88. Merge Sorted Array
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;


        int[] nums21 = {1};
        int[] nums22 = {};
        int m2 = 1, n2 = 0;

        solve(nums1, m, nums2, n);
        solve(nums21, m2, nums22, n2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums21));
    }

    public static void solve(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        int count = nums1.length - 1;
        int nPointer = n - 1;
        int mpointer = m - 1;

        while (count >= 0 && nPointer >= 0 && mpointer >= 0) {

            if (nums1[mpointer] > nums2[nPointer]) {
                nums1[count] = nums1[mpointer];
                nums1[mpointer] = Integer.MIN_VALUE;
                mpointer--;
            } else {
                nums1[count] = nums2[nPointer];
                nPointer--;
            }
            count--;
        }

        while (nPointer >= 0) {
            nums1[count] = nums2[nPointer];
            nPointer--;
            count--;
        }
    }
}
