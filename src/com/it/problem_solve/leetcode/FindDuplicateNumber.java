package com.it.problem_solve.leetcode;

/*
287. Find the Duplicate Number
 */
public class FindDuplicateNumber {

    public static void main(String[] args) {

    }

    private static int solve(int[] arr) {

        int sp = arr[0];
        int fp = arr[arr[0]];

        while (sp != fp) {
            sp = arr[sp];
            fp = arr[arr[fp]];
        }

        //Once they meet
        sp = 0;
        while (sp != fp) {
            sp = arr[sp];
            fp = arr[fp];
        }

        return fp;
    }
}
