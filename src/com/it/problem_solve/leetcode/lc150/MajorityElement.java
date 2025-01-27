package com.it.problem_solve.leetcode.lc150;

import java.util.HashMap;

/*
169. Majority Element
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(solve(nums));
        System.out.println(optmizedApproach(nums));
    }

    //Moore Voting Algorithm
    public static int optmizedApproach(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static int solve(int[] nums) {
        int maj = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int num : nums) {

            if (map.containsKey(num)) {
                int c = map.get(num);
                map.put(num, c + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > count) {
                count = map.get(num);
                maj = num;
            }
        }

        return maj;
    }
}
