package com.it.problem_solve.leetcode;

import java.util.Arrays;

public class KthMissingPositiveNum {

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        int[] arr2 = {1, 2, 3, 4, 5, 7, 8};
        int k2 = 3;

        System.out.println(linear(arr, k));
        System.out.println(linear(arr2, k2));

        System.out.println(linear2(arr, k));
        System.out.println(linear2(arr2, k2));
    }

    public static int binarySearch(int[] arr, int k) {
        //TODO
        int low = 1;
        int high = 100;

        while (low <= high) {

        }
        return 0;
    }

    //better approach. TC = O(N)
    public static int linear2(int[] arr, int k) {

        if (k < arr[0]) return k;

        for (int i = 0; i < arr.length; i++) {

            if (k < arr[i]) {
                return k;
            } else {
                k++;
            }
        }
        return k;
    }

    public static int linear(int[] arr, int k) {

        int i = 1;
        int ind = 0;

        while (ind < arr.length) {

            if (i == arr[ind]) {
                i++;
                ind++;
                continue;
            }

            while (i < arr[ind]) {
                k--;
                if (k == 0) {
                    return i;
                }
                i++;
            }
        }
        return arr[arr.length - 1] + k;
    }

}

// O(max(arr))