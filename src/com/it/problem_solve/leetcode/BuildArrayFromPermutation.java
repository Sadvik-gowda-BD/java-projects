package com.it.problem_solve.leetcode;

public class BuildArrayFromPermutation {

    public static void main(String[] args) {

    }

    public static int[] solve(int[] arr){
        int[] res = new int[arr.length];

        for (int i=0;i< arr.length;i++){
            res[i] = arr[arr[i]];
        }

        return res;
    }
}
