package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//40. Combination Sum II
public class CombinationSum2 {

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);
        solve(arr, 8, 0, new LinkedList<>(), 0, res);
        System.out.println(res);
    }

    public static void solve(int[] arr, int tar, int ind, LinkedList<Integer> ds, int sum, List<List<Integer>> res) {
        if (sum == tar) {
            res.add(new ArrayList<>(ds));
        }
        if (ind >= arr.length || sum > tar) {
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;

            ds.add(arr[i]);
            solve(arr, tar, i + 1, ds, sum + arr[i], res);
            ds.removeLast();
        }
    }
}
