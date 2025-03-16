package com.it.dsa.algorithms.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

//        int[] arr = {7, 3, 1, 2, 4, 10, 0};
        int[] arr = {3, 5, 2, 1, 4};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int l = low + 1; // Start from the next element
        int h = high;

        while (l <= h) {
            // Move l to the right until an element greater than pivot is found
            while (l <= h && arr[l] <= pivot) {
                l++;
            }

            // Move h to the left until an element smaller than pivot is found
            while (l <= h && arr[h] > pivot) {
                h--;
            }

            // Swap only if l is still less than h
            if (l < h) {
                swap(arr, l, h);
            }
        }

        // Swap pivot into correct position
        swap(arr, low, h);
        return h; // h is now the partition index
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
