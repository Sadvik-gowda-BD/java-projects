package com.it.problem_solve.leetcode.others;

public class ThreeConsecutiveOdds {

    public static void main(String[] args) {

        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};

        System.out.println(solve(arr));
    }

    public static boolean solve(int[] arr) {

        int oddCount = 0;

        for (int num : arr) {

            if (num % 2 == 1) {
                oddCount++;
                if (oddCount == 3) return true;
            } else {
                oddCount = 0;
            }
        }
        return false;
    }
}
