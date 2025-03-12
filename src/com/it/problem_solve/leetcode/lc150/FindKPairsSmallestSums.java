package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;

        List<List<Integer>> res = solve(nums1, nums2, k);
        System.out.println(res);

    }

    public static List<List<Integer>> solve(int[] a, int[] b, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int aLen = a.length, bLen = b.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            return (a1[0] + a1[1]) - (a2[0] + a2[1]);
        });

        for (int i = 0; i < aLen; i++) {
            pq.add(new int[]{a[i], b[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            k--;
            int[] currVal = pq.poll();
            result.add(List.of(currVal[0], currVal[1]));

            int bArrIndex = currVal[2];
            if (bArrIndex == bLen-1) continue;

            pq.add(new int[]{currVal[0], b[bArrIndex + 1], bArrIndex + 1});
        }

        return result;
    }
}
