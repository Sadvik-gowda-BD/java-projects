package com.it.problem_solve.leetcode.others2;


//367. Valid Perfect Square
public class ValidPerfectSquare {

    public static void main(String[] args) {

        System.out.println(solve(4));

    }

    private static boolean solve(int n) {

        if (n == 1) return true;

        int l = 1, r = n / 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long midSq = (long) mid * mid;
            if (midSq == n) return true;

            if (midSq > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

}
