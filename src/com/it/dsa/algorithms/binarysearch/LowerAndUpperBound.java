package com.it.dsa.algorithms.binarysearch;

public class LowerAndUpperBound {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 5, 7, 9, 9, 9};
        int target = 5;

        lowerBound(arr, target);
        upperBound(arr, target);

        System.out.println("--------");
        lowerBoundSoln2(arr, target);
        upperBoundSOln2(arr, target);
    }


    /*
    Lower Bound:
    The lower bound is the index of the first element in the sorted range that is greater than or equal to the target value.
     */
    //by using while (low <= high)
    public static void lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int ans = arr.length;

        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] < target) {
                low = mid + 1; //this cannot be an answer
            } else {
                ans = mid;
                high = mid - 1; //May be this can be my answer
            }
        }
        System.out.println("Lower bound = " + ans);
    }

    public static void lowerBoundSoln2(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        if (target > arr[high]) {
            System.out.println("Lower bound = " + high + 1);
            return;
        }

        while (low < high) {
            mid = (high + low) / 2;
            if (arr[mid] < target) {
                low = mid + 1; //this cannot be an answer
            } else {
                high = mid; //May be this can be my answer
            }
        }

        System.out.println("Lower bound soln2 = " + high + "/" + low);
    }


    /*
    The upper bound is the index of the first element in the sorted range that is strictly greater than the target value.
     */
    public static void upperBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int mid;
        int ans = arr.length;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        System.out.println("Upper bound = " + ans);
    }

    public static void upperBoundSOln2(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int mid;

        if (target >= arr[high]) {
            System.out.println("Lower bound = " + (high + 1));
            return;
        }
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        System.out.println("Upper bound = " + high + "/" + low);
    }
}
