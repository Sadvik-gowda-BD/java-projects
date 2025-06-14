package com.it.dsa.algorithms.binarysearch;


import java.util.Arrays;

//1482. Minimum Number of Days to Make m Bouquets
public class MinDaysToMakeNBouquet {

    public static void main(String[] args) {

        int[] arr1 = {1, 10, 3, 10, 2};
        int m1 = 3, k1 = 1;

        System.out.println(solveByBS(arr1, m1, k1));

        int[] arr2 = {1, 10, 3, 10, 2};
        int m2 = 3, k2 = 2;
        System.out.println(solveByBS(arr2, m2, k2));

        int[] arr3 = {7, 7, 7, 7, 12, 7, 7};
        int m3 = 2, k3 = 3;
        System.out.println(solveByBS(arr3, m3, k3));

    }

    //Binary search on answer
    public static int solveByBS(int[] bloomDay, int m, int k) {

        int len = bloomDay.length;

        if (len < ((long) m * k)) return -1;

        int high = Arrays.stream(bloomDay).max().orElse(0);
        int low = Arrays.stream(bloomDay).min().orElse(0);
        int ans = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean canMake(int[] bloomDay, int m, int k, int mid) {
        int totalBouquet = 0;
        int pickedFlower = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                pickedFlower++;

                if (pickedFlower == k) {
                    pickedFlower = 0;
                    totalBouquet++;
                    if (totalBouquet == m) return true;
                }
            } else {
                pickedFlower = 0;
            }
        }
        return false;
    }


    ///////////////////////////////////////
    public static int solveBruteForce(int[] bloomDay, int m, int k) {

        int len = bloomDay.length;
        if (len < ((long) m * k)) return -1;

        int maxDay = Arrays.stream(bloomDay).max().orElse(0);
        int day = Arrays.stream(bloomDay).min().orElse(0);;
        while (day <= maxDay) {
            if(noOfBouquetCanMake(bloomDay, day, k) >= m){
                return day;
            }
            day++;
        }

        return -1;
    }

    public static int noOfBouquetCanMake(int[] bloomDay, int day, int k) {

        int noOfBoq = 0;
        int pickFlower = 0;
        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {
                pickFlower++;

                if (pickFlower == k) {
                    noOfBoq++;
                    pickFlower = 0;
                }
            } else {
                pickFlower = 0;
            }
        }
        return noOfBoq;
    }
}
