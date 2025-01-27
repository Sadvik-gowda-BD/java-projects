package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

/*
135. Candy
Every child must get at least one candy.
A child with a higher rating should get more candies than their immediate neighbors.

 */
public class Candy {

    public static void main(String[] args) {

        int[] arr = {1, 0, 2};
        int[] arr2 = {1, 2, 2};
        int[] arr3 = {1, 3, 4, 5, 2};

        System.out.println(solve(arr));
        System.out.println(solve(arr2));
        System.out.println(solve(arr3));
    }

    private static int solve(int[] ratings) {

        int totalCandy = 0;
        int len = ratings.length;
        int[] candy = new int[len];

        Arrays.fill(candy, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(candy));
        for (int c : candy) {
            totalCandy += c;
        }

        return totalCandy;
    }
}
