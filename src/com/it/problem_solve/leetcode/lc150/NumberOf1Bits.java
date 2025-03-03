package com.it.problem_solve.leetcode.lc150;

public class NumberOf1Bits {

    public static void main(String[] args) {

        System.out.println(solve(3));
        System.out.println(solve(11));
        System.out.println(solve(128));
    }

    private static int solve(int num) {

        int count = 0;
        while (num > 0) {
            count += num & 1;
            num = num >> 1;

//            if (num % 2 != 0) {
//                count++;
//            }
//            num = num / 2;
        }
        return count;
    }
}
