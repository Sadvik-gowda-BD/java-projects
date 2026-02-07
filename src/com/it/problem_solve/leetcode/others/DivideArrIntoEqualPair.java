package com.it.problem_solve.leetcode.others;

import java.util.HashMap;

public class DivideArrIntoEqualPair {

    public static void main(String[] args) {

        int[] nums = {3, 2, 3, 8, 15, 2, 2, 15, 8, 2};

        System.out.println(solve3(nums));
    }

    //By Hash map
    public static boolean solve(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int c : map.values()) {
            if (c % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    //Frequency array
    public static boolean solve2(int[] nums) {

        int[] arr = new int[501];
        for (int num : nums) {
            arr[num]++;
        }

        for (int val : arr) {
            if (val % 2 == 1) return false;
        }
        return true;
    }

    /*
    Bit manipulation
    if XOR is 0 then it not means every element appear twice
    The XOR of 1 ^ 2 ^ 3 = 0
    However, this does not mean that every number appears an even number of times.
     */
    public static boolean solve3(int[] nums) {

        int[] arr = new int[501];
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
            arr[num]++;
        }

        if (res != 0) {
            return false;
        }

        for (int val : arr) {
            if (val % 2 == 1) return false;
        }
        return true;
    }
}
