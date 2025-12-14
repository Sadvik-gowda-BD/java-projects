package com.it.dsa.algorithms.sort;

import java.util.Arrays;

/*
    Time: O(n log n) (best/avg/worst)
    Space: O(n)
    It's preferred for linked lists
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 2, 4};
        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {

        if (!(l < r)) return;

        int mid = (l + r) / 2;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int leftLen = mid - l + 1;
        int rightLen = r - mid;

        int[] left = new int[leftLen];
        int[] right = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            left[i] = arr[i + l];
        }

        for (int i = 0; i < rightLen; i++) {
            right[i] = arr[i + mid + 1];
        }

        int lp = 0, rp = 0;
        int k = l;

        while (lp < leftLen && rp < rightLen) {
            if (left[lp] < right[rp]) {
                arr[k] = left[lp];
                lp++;
            } else {
                arr[k] = right[rp];
                rp++;
            }
            k++;
        }

        while (lp < leftLen) {
            arr[k] = left[lp];
            lp++;
            k++;
        }

        while (rp < rightLen) {
            arr[k] = right[rp];
            rp++;
            k++;
        }
    }
}
