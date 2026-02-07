package com.it.problem_solve.leetcode.others;

public class PowerOfThree {

    public static void main(String[] args) {

        System.out.println(solve(45));
    }

    private static boolean solve(int n) {

        while (n >= 1) {
            if (n == 1) {
                return true;
            }
            if (n % 3 != 0) {
                return false;
            }
            n = n/3;
        }
        return false;
    }
}
