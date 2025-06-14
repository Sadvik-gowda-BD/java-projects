package com.it.dsa.algorithms.binarysearch;

//35. Search Insert Position
public class InsertPosition {

    public static void main(String[] args) {

    }

    public static int solve(int[] arr, int tar) {
        int low = 0;
        int high = arr.length;
        int ans = 0;
        int mid;

        while (low <= high) {
            mid = (high + low) / 2;

            if (arr[mid] == tar) return mid;

            if (arr[mid] < tar) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int solve2(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int mid;

        if(tar>arr[high]) return high+1;
        while (low < high) {
            mid = (high + low) / 2;
            if (arr[mid] == tar) return mid;
            if (arr[mid] < tar) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
