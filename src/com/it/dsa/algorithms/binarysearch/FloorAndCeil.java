package com.it.dsa.algorithms.binarysearch;

public class FloorAndCeil {

    public static void main(String[] args) {

        int[] arr = {10,20,30,40,50};
        int tar = 25;

        floor(arr, tar);
        ceil(arr, tar);
    }

    //less than or equal to target
    public static void floor(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= tar) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("floor:" + ans);
    }

    //greater than or equal to target
    public static void ceil(int[] arr, int tar) {
        int low = 0;
        int high = arr.length;
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= tar) {
                ans = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("ceil:" + ans);
    }
}
