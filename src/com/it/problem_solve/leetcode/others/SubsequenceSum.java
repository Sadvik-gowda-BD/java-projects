package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//1498. Number of Subsequences That Satisfy the Given Sum Condition
public class SubsequenceSum {

    public static void main(String[] args) {

        int[] arr = {3, 5, 6, 7};
        int tSum = 9;

        int[] arr2 = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,
                5,18,20,7,5,5,15,19,14};
        int tar = 22;


        Arrays.sort(arr2);
        int result = solve1(arr2, tar, 0, new ArrayList<>());
        System.out.println(result);

    }

    public static int solve1(int[] arr, int tarSum, int ind, List<Integer> ds) {
        System.out.println(ind);
        if (ind >= arr.length) {
            if (!ds.isEmpty()) {
                int min = ds.get(0);
                int max = ds.get(ds.size() - 1);
                int sum = min + max;
                if (sum <= tarSum) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return 0;
        }

        ds.add(arr[ind]);
        int pick = solve1(arr, tarSum, ind + 1, ds);
        ds.remove(ds.size() - 1);
        int notPick = solve1(arr, tarSum, ind + 1, ds);
        return pick + notPick;
    }


    public static void solve2(int[] arr, int tarSum) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        solve2(arr, tarSum, 0, new ArrayList<>(), res);
        System.out.println(res);
    }

    public static void solve2(int[] arr, int tarSum, int ind, List<Integer> ds, List<List<Integer>> res) {
        if (ind >= arr.length) {
            if (!ds.isEmpty()) {
                int min = ds.get(0);
                int max = ds.get(ds.size() - 1);
                int sum = min + max;
                if (sum <= tarSum) {
                    res.add(new ArrayList<>(ds));
                } else {
                    return;
                }
            }
            return;
        }

        ds.add(arr[ind]);
        solve2(arr, tarSum, ind + 1, ds, res);
        ds.remove(ds.size() - 1);
        solve2(arr, tarSum, ind + 1, ds, res);
    }

}
