package com.it.problem_solve.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(twoPointer(nums1, nums2));
    }

    private static double twoPointer(int[] ar1, int[] ar2) {

        int l1 = ar1.length;
        int l2 = ar2.length;

        int preVal = 0;
        int currVal = 0;

        int arr1Pointer = 0;
        int arr2Pointer = 0;

        for (int i = 0; i <= (l1 + l2) / 2; i++) {
            preVal = currVal;

            if (arr1Pointer < l1 && arr2Pointer < l2) {
                if (ar1[arr1Pointer] < ar2[arr2Pointer]) {
                    currVal = ar1[arr1Pointer];
                    arr1Pointer++;
                } else {
                    currVal = ar2[arr2Pointer];
                    arr2Pointer++;
                }
            } else if (arr1Pointer < l1) {
                currVal = ar1[arr1Pointer];
                arr1Pointer++;
            } else {
                currVal = ar2[arr2Pointer];
                arr2Pointer++;
            }

        }
        System.out.println(preVal + " " + currVal);

        if ((l1 + l2) % 2 == 0) {
            return (currVal + preVal) / 2.0;
        } else {
            return currVal;
        }
    }

    private static double bruteFore(int[] ar1, int[] ar2) {

        int l1 = ar1.length;
        int l2 = ar2.length;
        int tArr[] = new int[l1 + l2];

        System.arraycopy(ar1, 0, tArr, 0, l1);
        System.arraycopy(ar2, 0, tArr, l1, l2);
        Arrays.sort(tArr);
        int mid = (l1 + l2) / 2;
        System.out.println("mid " + mid);
        if ((l1 + l2) % 2 == 0) {
            return (tArr[mid] + tArr[mid - 1]) / 2.0;

        }
        return tArr[mid];
    }


}
