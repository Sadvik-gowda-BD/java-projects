package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.HashMap;
import java.util.Map;

/*
128. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(solveByDsu(nums1));
        System.out.println(solveByDsu(nums2));
    }

    public static int solveByDsu(int[] nums) {
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


    public static int solveByHashMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            int pre = n - 1;
            int post = n + 1;

            if (map.containsKey(n)) {
                continue;
            }

            if (!map.containsKey(pre) && !map.containsKey(post)) {
                map.put(n, 1);
            } else if (map.containsKey(pre) && !map.containsKey(post)) {
                int val = map.get(pre) + 1;
                map.put(n, val);
                map.put(n - map.get(pre), val);
            } else if (!map.containsKey(pre) && map.containsKey(post)) {
                int val = map.get(post) + 1;
                map.put(n, val);
                map.put(n + map.get(post), val);
            } else {
                int preVal = map.get(pre);
                int postVal = map.get(post);
                int val = preVal + postVal + 1;
                map.put(n, val);
                map.put(n - preVal, val);
                map.put(n + postVal, val);
            }
        }

        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        System.out.println(max);
        return max;
    }

}
