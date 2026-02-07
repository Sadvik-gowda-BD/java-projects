package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

//2358. Maximum Number of Groups Entering a Competition
public class MaxNoOfGroup {

    public static void main(String[] args) {

        System.out.println(solve(new int[]{10, 6, 12, 7, 3, 5}));
        System.out.println(solve(new int[]{8, 8}));

    }

    public static int solve(int[] grades) {

        Arrays.sort(grades);

        int len = grades.length;

        int groups = 0;
        int l = 0;

        while ((l + groups) < len) {
            groups++;
            l += groups;
        }
        return groups;
    }


}
