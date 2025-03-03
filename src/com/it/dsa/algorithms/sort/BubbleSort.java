package com.it.dsa.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {12, 1, 5, 2, 4, 3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
        Time Complexity: O(N2)
        Auxiliary Space: O(1)
     */
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
