package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

//2929. Distribute Candies Among Children II
public class DistributionCandies2 {

    static long ans = 0;

    public static void main(String[] args) {


        System.out.println(solve(5, 2));
    }

    public static long solve(int n, int limit) {
        int[] std = new int[3];
        solve(n, limit, 0, std);
        return ans;
    }

    public static void solve(int n, int lim, int currCand, int[] std) {

        if (currCand == n) {
            ans++;
            return;
        }

        for (int s = 0; s < std.length; s++) {
            if (std[s] < lim) {
                std[s]++;
                solve(n, lim, currCand + 1, std);
                std[s]--;
            }
        }

    }
}
