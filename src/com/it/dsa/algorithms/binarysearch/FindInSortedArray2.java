package com.it.dsa.algorithms.binarysearch;

public class FindInSortedArray2 {

    public static void main(String[] args) {

        int[] arr1 = {2, 5, 6, 0, 0, 1, 2};
        int t1 = 0;
        System.out.println(solve(arr1, t1));

        int[] arr2 = {1, 0, 1, 1, 1};
        int t2 = 0;
        System.out.println(solve(arr2, t2));
    }


    public static boolean solve(int[] arr, int tar) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (tar == arr[mid]) {
                return true;
                //Check in sorted part (either left or right half any one is sorted)
            }

            //when low mid and high has same element then shrink the array
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[mid] >= arr[low]) { //left half is sorted
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
        return false;
    }
}
