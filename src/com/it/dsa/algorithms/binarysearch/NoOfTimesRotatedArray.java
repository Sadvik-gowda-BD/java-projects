package com.it.dsa.algorithms.binarysearch;

public class NoOfTimesRotatedArray {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2};

        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        int minEle = Integer.MAX_VALUE;
        int ind = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[mid]) {
                if (arr[low] < minEle) {
                    minEle = arr[low];
                    ind = low;
                }
                low=mid+1;
            } else {
                if (arr[mid] < minEle) {
                    minEle = arr[mid];
                    ind = mid;
                }
                high=mid-1;
            }

        }

        System.out.println("Min ele:"+ minEle);

        return ind;
    }
}
