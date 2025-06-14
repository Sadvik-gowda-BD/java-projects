package com.it.dsa.algorithms.binarysearch;

public class SingleElementInsortArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};

        System.out.println(solve(arr));

    }
/*
    (even, odd) - Single element will be on right half, so we can eliminate left half
    (odd, even) - Single element will be on left half, so we can eliminate right half
 */
    public static int solve(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[high] != arr[high - 1]) return arr[high];

        while (low <= high) {
            int mid = (high + low) / 2;

            if (arr[mid - 1] != arr[mid] && arr[mid + 1] != arr[mid]) return arr[mid];

            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}
