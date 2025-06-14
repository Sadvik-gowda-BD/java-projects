package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.List;

//77. Combinations
public class CombinationsOfK {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        List<List<Integer>> res = new ArrayList<>();

        solve(arr, 0, new ArrayList<>(), res, k);
        System.out.println(res);
    }

    public static void solve(int[] arr, int start, List<Integer> ls, List<List<Integer>> res, int k) {
        if (ls.size() == k) {
            res.add(new ArrayList<>(ls));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            ls.add(arr[i]);
            solve(arr, i + 1, ls, res, k);
            ls.remove(ls.size() - 1);
        }
    }
}
