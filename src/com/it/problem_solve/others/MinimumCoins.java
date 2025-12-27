package com.it.problem_solve.others;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
322. Coin Change
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
 */
public class MinimumCoins {

    private static int finalCount = 0;

    public static void main(String[] args) {
//        List<Integer> coins = Arrays.asList(1, 2, 5, 10, 50, 100, 500, 1000);
        int[] coins2 = new int[]{6, 3, 2};
        System.out.println(solveByDp(coins2, 10));
    }

    static int solveByDp(int[] coins, int price) {
        int[] dp = new int[price + 1];
        //fill Infinity
        Arrays.fill(dp, Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Arrays.toString(dp));

        dp[0] = 0; //for 0 price 0 coin is required

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                int ind = i - coin;
                if (ind >= 0 && dp[ind] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[ind] + 1);
                }
            }
        }
        return dp[price] == Integer.MAX_VALUE ? -1 : dp[price];
    }



    public int solveByRec(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int minCount = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = solveByRec(coins, amount - coin);
            if (res >= 0 && res < minCount) {
                minCount = 1 + res;
            }
        }

        return (minCount == Integer.MAX_VALUE) ? -1 : minCount;
    }


    //Memoization
    public int solveByMemo(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        // Fill with a value to indicate not computed yet
        Arrays.fill(memo, -2);
        return solve(coins, amount, memo);
    }

    private int solve(int[] coins, int rem, int[] memo) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (memo[rem] != -2) return memo[rem];

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, rem - coin, memo);
            if (res >= 0 && res < minCount) {
                minCount = 1 + res;
            }
        }
        memo[rem] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
        return memo[rem];
    }

    //Not working, greedy. Greedy approach won't work in this problem
    private static int getMinimumCoins2(int[] coin1, int price) {
        Integer[] coins = new Integer[coin1.length];
        for (int i = 0; i < coin1.length; i++) {
            coins[i] = coin1[i];
        }
        int noOfCoins = 0;
        Arrays.sort(coins, Collections.reverseOrder());

        for (int coin : coins) {
            int q = price / coin;
            price -= (q * coin);
            noOfCoins += q;

            if (price == 0) {
                return noOfCoins;
            }
        }
        return noOfCoins;

    }


}
