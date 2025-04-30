package com.it.problem_solve.leetcode;

import java.util.Arrays;

public class FIndInSortedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] arr2 = {1, 3};

        System.out.println(Arrays.toString(arr));
        System.out.println(solve(arr, 8));
    }

    //1,3
    public static int solve(int[] arr, int tar) {
        int len = arr.length;
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
//            System.out.println("l:" + l + " r:" + r + " m:" + mid);
            if (tar == arr[mid]) {
                return mid;
                //Check in sorted part (either left or right half any one is sorted)
            } else if (arr[mid] >= arr[l]) { //left half is sorted
                if (tar >= arr[l] && tar < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { //right half is sorted
                if (arr[mid] < tar && tar <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
