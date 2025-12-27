package com.it.dsa.algorithms.binarysearch;

import java.util.Arrays;

/*
34. Find First and Last Position of Element in Sorted Array
 */
public class FirstAndLastPosOfEle {

    public static void main(String[] args) {

        //1,2,3
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] res = solve(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] solve(int[] arr, int ele) {

        int firstOccurrence = findStartInd(arr, ele);
        if (firstOccurrence == -1) {
            //if first occurrence is not then given element is not exist in array
            return new int[]{-1, -1};
        }
        int lastOccurrence = findLastInd(arr, ele);
        int[] res = {firstOccurrence, lastOccurrence};
        return res;
    }

    public static int findStartInd(int[] arr, int ele) {

        int low = 0;
        int high = arr.length - 1;
        int mid;
        int ans = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == ele) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int findLastInd(int[] arr, int ele) {

        int low = 0;
        int high = arr.length - 1;
        int mid;
        int ans = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == ele) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
