package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.List;

/*
228. Summary Ranges
 */
public class SummaryRanges {

    public static void main(String[] args) {

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};

        System.out.println(solve(nums1));
        System.out.println(solve(nums2));

    }

    public static List<String> solve(int[] nums) {
        List<String> result = new ArrayList<>();
        int len = nums.length;

        if (len == 0) {
            return result;
        } else if (len == 1) {
            result.add(String.valueOf(nums[0]));
        }

        int n1 = 0;
        boolean isNew = true;
        for (int i = 0; i < len - 1; i++) {
            if (isNew) {
                n1 = nums[i];
            }

            if (nums[i] != nums[i + 1] - 1) {
                isNew = true;
                String st = "";
                if (n1 == nums[i]) {
                    st = st + n1;
                } else {
                    st = st + n1 + "->" + nums[i];
                }
                result.add(st);
                n1 = nums[i + 1];
            } else {
                isNew = false;
            }

        }

        String st = "";
        if (n1 == nums[len - 1]) {
            st = st + n1;
        } else {
            st = st + n1 + "->" + nums[len - 1];
        }
        result.add(st);


        return result;
    }
}
