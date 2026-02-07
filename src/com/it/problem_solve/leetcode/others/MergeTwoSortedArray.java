package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

/*
   Merge 2 sorted array with O(N)
  Input - [1,4,6,7], [2,3,5]
  Output - [1,2,3,4,5,6,7]
   */
public class MergeTwoSortedArray {

    public static void main(String[] args) {

    }

    private static void mergeArray(int[] arr1, int[] arr2) {

        int minLen = Math.min(arr1.length, arr2.length);
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        int[] mergedArray = new int[arr1.length + arr2.length];

        while (a1 < arr1.length && a2 < arr2.length) {
            if (arr1[a1] < arr2[a2]) {
                mergedArray[a3] = arr1[a1];
                a1++;
            } else {
                mergedArray[a3] = arr2[a2];
                a2++;
            }
            a3++;
        }

        if (a1 != arr1.length) {
            for (int i = a1; i < arr1.length; i++) {
                mergedArray[a3] = arr1[i];
                a3++;
            }
        }

        if (a2 != arr2.length) {
            for (int i = a2; i < arr2.length; i++) {
                mergedArray[a3] = arr2[i];
                a3++;
            }
        }

        System.out.println(Arrays.toString(mergedArray));

    }

}
