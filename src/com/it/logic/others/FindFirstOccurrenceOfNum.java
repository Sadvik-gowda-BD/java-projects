package com.it.logic.others;

//find the index for element K in the sorted array, if there are multiple elements of K then find the first occurrence
public class FindFirstOccurrenceOfNum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int K = 2;
        int index = findFirstOccurrence(arr, K);
        System.out.println("First occurrence of " + K + " is at index: " + index);
    }

    public static int findFirstOccurrence(int[] arr, int K) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == K) {
                result = mid; // Update result to current mid
                high = mid - 1; // Move to the left side of the array
            } else if (arr[mid] > K) {
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return result; // If K is not found, result will be -1
    }
}
