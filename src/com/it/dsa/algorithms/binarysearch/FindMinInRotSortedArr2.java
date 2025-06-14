package com.it.dsa.algorithms.binarysearch;

//154. Find Minimum in Rotated Sorted Array II
public class FindMinInRotSortedArr2 {

    public static void main(String[] args) {


        int[] arr = {2, 2, 2, 0, 1};

        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            //   4,2,3,4, 4,4,4,4,
            //   4,4,4,4, 4,1,2,3,
            //4,5,6,7 1,2,3
            //11119999999
            //3,1,1
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                ans = Math.min(arr[mid], ans);
                low++;
                high--;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                ans = Math.min(arr[low], ans);
                low = mid + 1;
            } else {
                ans = Math.min(arr[mid], ans);
                high = mid - 1;
            }
        }
        return ans;
    }

}
