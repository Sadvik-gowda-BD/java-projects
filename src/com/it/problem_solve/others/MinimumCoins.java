package com.it.problem_solve.others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumCoins {

    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1, 2, 5, 10, 50, 100, 500, 1000);
        System.out.println(getMinimumCoins(coins, 58));
    }

    private static int getMinimumCoins(List<Integer> coins, int price) {
        int noOfCoins = 0;
        coins.sort(Comparator.reverseOrder());

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
