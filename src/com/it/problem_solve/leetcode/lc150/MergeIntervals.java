package com.it.problem_solve.leetcode.lc150;

import com.it.problem_solve.util.PrintArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    public static void main(String[] args) {

        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solve(arr);
        PrintArray.printArray(res);
    }

    //Clean code
    public static int[][] solve2(int[][] arr) {
        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);

        List<int[]> res = new ArrayList<>();
        int[] pre = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int[] curr = arr[i];
            if (curr[0] <= pre[0]) {
                pre[1] = Math.max(pre[1], arr[i][1]);
            } else {
                res.add(pre);
                pre = curr;
            }
        }
        res.add(pre);
        return res.toArray(new int[res.size()][]);

    }

    public static int[][] solve(int[][] arr) {

        if (arr.length == 0) {
            return arr;
        }
        Comparator<int[]> cp = (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        };

        Arrays.sort(arr, cp);
        int len = arr.length;
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> ls = new ArrayList<>();
        ls.add(arr[0][0]);
        ls.add(arr[0][1]);
        res.add(ls);

        for (int i = 1; i < len; i++) {
            int lisIndex = res.size() - 1;
            int preEnd = res.get(lisIndex).get(1);

            int currStart = arr[i][0];
            int currEnd = arr[i][1];

            if (currEnd <= preEnd) {
                continue;
            }
            if (currStart <= preEnd) {
                List<Integer> preInterval = res.get(lisIndex);
                preInterval.set(1, currEnd);
            } else {
                List<Integer> inter = new ArrayList<>();
                inter.add(currStart);
                inter.add(currEnd);
                res.add(inter);
            }
        }

        int[][] resArray = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            resArray[i][0] = res.get(i).get(0);
            resArray[i][1] = res.get(i).get(1);
        }
        return resArray;
    }
}
