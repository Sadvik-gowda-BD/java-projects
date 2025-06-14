package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.List;

//39. Combination Sum
public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, target, 0, 0, new ArrayList<>(), res);

        System.out.println(res);
    }

    public static void solve(int[] arr, int tar, int sum, int start, List<Integer> ls, List<List<Integer>> res) {
        System.out.println(start);
        if (tar == sum) {
            res.add(new ArrayList<>(ls));
            return;
        } else if (sum > tar) {
            return;
        }

        for (int i = start; i < arr.length; i++) {
            ls.add(arr[i]);
            sum += arr[i];
            solve(arr, tar, sum, i, ls, res);
            sum -= arr[i];
            ls.remove(ls.size() - 1);
        }
    }
}
