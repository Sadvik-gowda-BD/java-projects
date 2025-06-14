package com.it.dsa.algorithms.binarysearch;

//153. Find Minimum in Rotated Sorted Array
public class FindMinInRotedSortArray {

    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2};
        int[] arr2 = {3,1,2};

        System.out.println(solve(arr));
        System.out.println(solve(arr2));
    }

    public static int solve(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //To improve performance. If current search space is sorted then no need to check further
            if(arr[low]<arr[high]){
                min = Math.min(min, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
