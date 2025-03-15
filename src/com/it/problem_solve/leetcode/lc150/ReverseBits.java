package com.it.problem_solve.leetcode.lc150;

public class ReverseBits {

    public static void main(String[] args) {

        System.out.println(solve(43261596));
    }

    public static int solve(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1); // or res += (n & 1);
            n = n >> 1;
        }
        return res;
    }

}
