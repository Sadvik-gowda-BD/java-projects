package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//78. Subsets
public class Subsets {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        List<List<Integer>> res = solve(nums);
        System.out.println(res);

    }

    public static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        rec(ans, sub, nums, 0, nums.length);

        return ans;
    }

    public static void rec(List<List<Integer>> res, List<Integer> sub, int[] nums, int ind, int len) {

        res.add(new ArrayList<>(sub));
        for (int i = ind; i < len; i++) {
            sub.add(nums[i]);
            rec(res, sub, nums, i + 1, len);
            sub.remove(sub.size()-1);
        }
    }
}
