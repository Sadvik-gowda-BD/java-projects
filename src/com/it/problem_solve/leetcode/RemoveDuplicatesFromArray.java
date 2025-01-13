package com.it.problem_solve.leetcode;

import java.util.Arrays;

/*
80. Remove Duplicates from Sorted Array II

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]

 */
public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        int l = solve(arr);

        System.out.println(l);

        System.out.println(Arrays.toString(arr));

    }

    private static int solve(int[] arr) {
        int l = 1;
        int r = 1;
        int len = arr.length;

        int count = 1;
        int preEle = arr[0];

        while (r < len) {

            if (arr[r] == preEle) {
                count++;

                if (count <= 2) {
                    swap(arr, l, r);
                    l++;
                }
            } else {
                preEle = arr[r];
                count = 1;
                swap(arr, l, r);
                l++;
            }
            r++;
        }

        return l;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
