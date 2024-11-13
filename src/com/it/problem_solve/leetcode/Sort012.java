package com.it.problem_solve.leetcode;

import java.util.Arrays;

public class Sort012 {

    public static void main(String[] args) {

        int[] arr = {2, 0, 1, 2, 2, 0, 1, 2, 1, 0};
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        int len = arr.length;

        int p0 = 0;
        int p1 = 0;
        int p2 = len - 1;

        while (p1 <= p2) {

            if (arr[p1] == 0) {
                swap(arr, p1, p0);
                p0++;
                p1++;
            } else if (arr[p1] == 1) {
                p1++;
            } else {
                swap(arr, p1, p2);
                p2--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
