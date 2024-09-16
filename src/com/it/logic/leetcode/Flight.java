package com.it.logic.leetcode;

import java.util.Arrays;

public class Flight {

    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};

        int[] result1 = flightBookings(bookings, 5);
        int[] result2 = prefixSum(bookings, 5);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    public static int[] prefixSum(int[][] bookings, int n){

        int[] arr = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] row = bookings[i];
            int start = row[0];
            int end = row[1];
            arr[start-1] = arr[start-1] + row[2];
            if(end == n) continue;
            arr[end] = arr[end] - row[2];
        }

        for(int i=1;i<n;i++){
            arr[i] = arr[i]+arr[i-1];
        }
        return arr;
    }

    public static int[] flightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] b = bookings[i];
            int start = b[0];
            int end = b[1];
            for (int j = start - 1; j < end; j++) {
                arr[j] = arr[j] + b[2];
            }
        }
        return arr;
    }
}
