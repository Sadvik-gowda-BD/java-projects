package com.it.problem_solve.leetcode;

/*
stock buy sell
 */
public class StockBuySell {

    public static void main(String[] args) {

        int arr[] = {7, 6, 4, 3, 1};

        System.out.println(bruteforce(arr));
        System.out.println(solve(arr));

    }

    public static int solve(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            int curProfit = arr[i] - min;
            min = Math.min(min, arr[i]);
            maxProfit = Math.max(curProfit, maxProfit);
        }
        return maxProfit;
    }


    public static int bruteforce(int[] arr) {
        int len = arr.length;
        int maxProfit = 0;

        for (int i = 0; i < len - 1; i++) {

            for (int j = i; j < len; j++) {
                int p = arr[j] - arr[i];
                maxProfit = Math.max(p, maxProfit);
            }
        }
        return maxProfit;
    }
}
