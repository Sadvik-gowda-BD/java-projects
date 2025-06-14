package com.it.dsa.algorithms.binarysearch;

import java.util.Arrays;

//410. Split Array Largest Sum
public class SplitArrayLargestSum {

    public static void main(String[] args) {

        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;

        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 2;

        System.out.println(solveByBruteforce(arr, k));
        System.out.println(solveByBruteforce(arr2, k2));

        System.out.println(solveByBS(arr, k));
        System.out.println(solveByBS(arr2, k2));
    }

    public static int solveByBS(int[] arr, int k) {

        int min = Arrays.stream(arr).max().orElse(0);
        int max = Arrays.stream(arr).sum();
        int ans = 0;

        while (min <= max) {

            int mid = min + ((max - min) / 2);
            int partitions = partition(arr, mid);

//            if(partitions==k){
//                ans=mid;
//                max = mid-1;
//            }
            if (partitions <= k) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }


        return ans;
    }

    public static int solveByBruteforce(int[] arr, int k) {

        int sum = Arrays.stream(arr).max().orElse(0);
        int max = Arrays.stream(arr).sum();

        while (sum <= max) {
            int partitions = partition(arr, sum);
            if (partitions <= k) {
                return sum;
            }
            sum++;
        }

        return sum;
    }

    public static int partition(int[] arr, int tarSum) {

        int currSum = 0;
        int partition = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + currSum > tarSum) {
                partition++;
                currSum = arr[i];
            } else {
                currSum += arr[i];
            }
        }
        partition++;

        return partition;
    }
}
