package com.it.problem_solve.leetcode.others2;


//334. Increasing Triplet Subsequence
public class IncreasingTripletSubsequence {

    private static boolean solveByOpt2(int[] arr) {

        int len = arr.length;
        if (arr.length < 3) return false;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;


        for (int i = 0; i < len; i++) {
            int curr = arr[i];

            if (curr > min2) return true;

            if (curr <= min1) {
                min1 = curr;
            } else if (curr <= min2) {
                min2 = curr;
            }
        }
        return false;
    }


    private static boolean solveByBf(int[] arr) {

        int len = arr.length;
        if (arr.length < 3) return false;

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (arr[i] < arr[j] && arr[j] < arr[k]) return true;
                }
            }
        }
        return false;
    }

}
