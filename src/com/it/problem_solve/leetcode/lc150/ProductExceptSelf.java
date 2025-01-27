package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {

        int[] n1 = {1, 2, 3, 4};
        int[] n2 = {-1, 1, 0, -3, 3};

        System.out.println(Arrays.toString(solve(n1)));
        System.out.println(Arrays.toString(solve(n2)));
    }

    private static int[] solve(int[] arr) {
        int len = arr.length;
        int[] ans = new int[len];

        int zeroCount = 0;
        long product = 1;
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            product *= num;
        }

        System.out.println(product);
        for (int i = 0; i < len; i++) {
            if (zeroCount == 0) {
                ans[i] = (int) (product / arr[i]);
            } else if (zeroCount > 1) {
                ans[i] = 0;
            } else {
                if (arr[i] != 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = (int) product;
                }
            }
        }

        return ans;
    }
}
