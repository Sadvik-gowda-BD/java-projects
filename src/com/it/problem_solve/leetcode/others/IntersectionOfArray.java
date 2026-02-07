package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArray {

    public static void main(String[] args) {

        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = solve(nums1, nums2);

        System.out.println(Arrays.toString(res));

    }

    private static int[] solve(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        ;
        int l2 = nums2.length;

        int p1 = 0;
        int p2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ls = new ArrayList<>();

        while (p1 < l1 && p2 < l2) {

            if (nums1[p1] == nums2[p2]) {
                ls.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] res = new int[ls.size()];

        for (int i = 0; i < ls.size(); i++) {
            res[i] = ls.get(i);
        }

        return res;
    }
}
