package com.it.dsa.algorithms.binarysearch;

import java.util.Arrays;

public class FIndInSortedArray {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] arr2 = {1, 3};

        System.out.println(Arrays.toString(arr));
        System.out.println(solve(arr, 8));
    }

    public static int solve(int[] arr, int tar) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
//            System.out.println("low:" + low + " high:" + high + " m:" + mid);
            if (tar == arr[mid]) {
                return mid;
                //Check in sorted part (either left or right half any one is sorted)
            } else if (arr[mid] >= arr[low]) { //left half is sorted
                if (tar >= arr[low] && tar < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //right half is sorted
                if (arr[mid] < tar && tar <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
