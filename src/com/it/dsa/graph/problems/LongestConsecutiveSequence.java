package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(solve(nums1));
        System.out.println(solve(nums2));
    }

    public static int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        DisjointSet ds = new DisjointSet(len);

        for (int i = 0; i < len; i++) {
            if (valueToIndex.containsKey(nums[i])) {
                continue;
            }

            valueToIndex.put(nums[i], i);

            int v1 = nums[i] - 1;
            int v2 = nums[i] + 1;
            if (valueToIndex.containsKey(v1)) {
                ds.unionBySize(i, valueToIndex.get(v1));
            }
            if (valueToIndex.containsKey(v2)) {
                ds.unionBySize(i, valueToIndex.get(v2));
            }
        }

        return ds.getMaxSize();
    }
}
