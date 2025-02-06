package com.it.problem_solve.leetcode.lc150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ContainsDuplicate2 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {1, 0, 1, 1};

        System.out.println(solve(arr, 3));
        System.out.println(solve(arr2, 1));

    }

    private static boolean solve(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(num)) <= k) {
                    return true;
                } else {
                    map.put(num, i);
                }
            } else {
                map.put(num, i);
            }
        }

        return false;
    }

    public boolean solve2(int[] nums, int k) {
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(h.contains(nums[i])) return true;
            h.add(nums[i]);
            if(h.size()>k)
                h.remove(nums[i-k]);
        }
        return false;
    }
}
