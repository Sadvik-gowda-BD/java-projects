package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

public class BuySellStock4 {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 7};
        int[] arr1 = new int[]{2, 4, 1};

        int[] arr2 = new int[]{3, 2, 6, 5, 0, 3};

        System.out.println(solveByRec(arr1, 2));
        System.out.println(solveByMemo(arr2, 3));
    }

    public static int solveByMemo(int[] prices, int k) {

        int[][][] dp = new int[prices.length][k + 1][2]; // priceInd noOfTxn canBuy

        for (int[][] arr1 : dp) {
            for (int[] arr2 : arr1) {
                Arrays.fill(arr2, -1);
            }
        }

        return solveByMemo(prices, 0, true, k, dp);
    }

    public static int solveByMemo(int[] price, int ind, boolean canBuy, int noOfTxn, int[][][] dp) {

        if (noOfTxn == 0 || ind == price.length) {
            return 0;
        }

        int canByInd = canBuy ? 1 : 0;
        if (dp[ind][noOfTxn][canByInd] != -1) {
            return dp[ind][noOfTxn][canByInd];
        }

        int ans;
        if (canBuy) {
            int buy = -price[ind] + solveByMemo(price, ind + 1, false, noOfTxn, dp);
            int skip = solveByMemo(price, ind + 1, canBuy, noOfTxn, dp);
            ans = Math.max(buy, skip);
        } else {
            int sell = price[ind] + solveByMemo(price, ind + 1, true, noOfTxn - 1, dp);
            int skip = solveByMemo(price, ind + 1, canBuy, noOfTxn, dp);
            ans = Math.max(sell, skip);
        }

        dp[ind][noOfTxn][canByInd] = ans;

        return ans;
    }


    public static int solveByRec(int[] prices, int k) {
        return solveByRec(prices, 0, true, k);
    }

    public static int solveByRec(int[] price, int ind, boolean canBuy, int noOfTxn) {

        if (noOfTxn == 0 || ind == price.length) {
            return 0;
        }

        int ans;
        if (!canBuy) {
            int buy = -price[ind] + solveByRec(price, ind + 1, true, noOfTxn);
            int skip = solveByRec(price, ind + 1, canBuy, noOfTxn);
            ans = Math.max(buy, skip);
        } else {
            int sell = price[ind] + solveByRec(price, ind + 1, false, noOfTxn - 1);
            int skip = solveByRec(price, ind + 1, canBuy, noOfTxn);
            ans = Math.max(sell, skip);
        }

        return ans;
    }

}
