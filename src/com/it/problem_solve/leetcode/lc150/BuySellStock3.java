package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

public class BuySellStock3 {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 3, 5, 0, 0, 3, 1, 4};

        int[] arr2 = new int[]{14, 9, 10, 12, 4, 8, 1, 16};

        System.out.println(solveByRec2(arr2));
        System.out.println(solveByMemo(arr2));

    }


    public static int solveByMemo(int[] prices) {

        int[][][] dp = new int[prices.length][2][2]; //[price ind][remainTxn][isHolding]
        for (int[][] arr : dp) {
            for (int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }
        return solveByMemo(prices, 0, false, 2, dp);
    }

    public static int solveByMemo(int[] price, int ind, boolean isHolding, int remainTxn, int[][][] dp) {

        if (remainTxn == 0 || ind == price.length) {
            return 0;
        }

        int j = remainTxn == 1 ? 0 : 1;
        int k = isHolding ? 0 : 1;

        if (dp[ind][j][k] != -1) {
            return dp[ind][j][k];
        }


        int ans;
        if (!isHolding) {
            int buy = -price[ind] + solveByMemo(price, ind + 1, true, remainTxn, dp);
            int skip = solveByMemo(price, ind + 1, isHolding, remainTxn, dp);
            ans = Math.max(buy, skip);
        } else {
            int sell = price[ind] + solveByMemo(price, ind + 1, false, remainTxn - 1, dp);
            int skip = solveByMemo(price, ind + 1, isHolding, remainTxn, dp);
            ans = Math.max(sell, skip);
        }

        dp[ind][j][k] = ans;
        return ans;
    }

    public static int solveByRec2(int[] prices) {

        return solveByRec2(prices, 0, false, 2);
    }

    public static int solveByRec2(int[] price, int ind, boolean isHolding, int remainTxn) {

        if (remainTxn == 0 || ind == price.length) {
            return 0;
        }

        int res1 = 0;
        if (!isHolding) {
            res1 = -price[ind] + solveByRec2(price, ind + 1, true, remainTxn);
        }

        if (isHolding) {
            res1 = price[ind] + solveByRec2(price, ind + 1, false, remainTxn - 1);
        }

        int skip = solveByRec2(price, ind + 1, isHolding, remainTxn);

        return Math.max(skip, res1);
    }


    //Not recommended
    private static int solveByRec(int[] prices) {

        return solveByRec(prices, 0, 0, -1);
    }

    private static int solveByRec(int[] prices, int ind, int txn, int broughtInd) {

        if (txn == 2 || ind == prices.length) {
            return 0;
        }

        int res1 = 0;
        int res2 = 0;

        if (broughtInd == -1) {
            res1 = solveByRec(prices, ind + 1, txn, ind);
        }

        if (broughtInd != -1 && prices[ind] > prices[broughtInd]) {
            res2 = (prices[ind] - prices[broughtInd]) + solveByRec(prices, ind + 1, txn + 1, -1);
        }

        int res3 = solveByRec(prices, ind + 1, txn, broughtInd);

        return Math.max(res3, Math.max(res1, res2));
    }

}
