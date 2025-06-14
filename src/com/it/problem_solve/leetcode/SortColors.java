package com.it.problem_solve.leetcode;

import java.util.Arrays;

//75. Sort Colors
public class SortColors {

    public static void main(String[] args) {

        int[] arr = {2,0,2,1,1,0};

        solve(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void solve(int[] arr) {
        int zero = 0;
        int one = 0;
        int two = arr.length - 1;

        while (one <= two) {

            if (arr[one] == 0) {
                swap(arr, one, zero);
                one++;
                zero++;
            } else if (arr[one] == 2) {
                swap(arr, one, two);
                two--;
            } else {
                one++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
