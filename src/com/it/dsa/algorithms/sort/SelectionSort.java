package com.it.dsa.algorithms.sort;

import java.util.Arrays;

/*
1) Array is considered into 2 parts sorted and unsorted array, initially whole array is unsorted
2)Select the lowest element in the remaining array
3)Bring it to the starting position
4)Change the counter for unsorted array by one

The algorithm repeatedly selects the smallest (or largest) element from the unsorted portion of the list and swaps it
with the first element of the unsorted part. This process is repeated for the remaining unsorted portion until the
 entire list is sorted.
 */
public class SelectionSort {

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
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
