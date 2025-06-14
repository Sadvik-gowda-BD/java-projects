package com.it.dsa.algorithms.binarysearch;

public class SearchElementIndex {

    public static void main(String[] args) {

        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};

        System.out.println(solveByIteration(arr, 6));
        System.out.println(solveByRecursion(arr, 6));

        System.out.println("--------------------");
        System.out.println(solveByIteration(arr, 8));
        System.out.println(solveByRecursion(arr, 8));
    }

    public static int solveByIteration(int[] arr, int ele) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == ele) {
                return mid;
            } else if (ele > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int solveByRecursion(int[] arr, int ele) {
        int left = 0;
        int right = arr.length - 1;
        return rec(arr, ele, left, right);
    }

    public static int rec(int[] arr, int ele, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (arr[mid] == ele) {
            return mid;
        } else if (ele > arr[mid]) {
            return rec(arr, ele, mid + 1, right);
        } else {
            return rec(arr, ele, left, mid - 1);
        }
    }
}
