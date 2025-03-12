package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {

    public static void main(String[] args) {

        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};

        System.out.println(solve(k, w, profits, capital));
        System.out.println(solveOptimize(k, w, profits, capital));
    }

    /*
    Sorting: O(N logN)
    Heap insertion N elements: O(N logN)
    Heap polling for K elements: O(K logN)

    Final TC: O(NlogN + klogN)
     */
    public static int solveOptimize(int k, int w, int[] profits, int[] capital) {
        int currCap = w;
        int len = profits.length;

        int[][] projects = new int[len][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < len; i++) {
            projects[i] = new int[]{capital[i], profits[i]};
        }

        //sort based on capital in increase order
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        int ind = 0;
        while (k-- > 0) {
            while (ind < len) {
                if (projects[ind][0] <= currCap) {
                    pq.add(projects[ind]);
                    ind++;
                } else {
                    break;
                }
            }
            if (pq.isEmpty()) break;
            int[] ele = pq.poll();
            currCap += ele[1];
        }
        return currCap;
    }

    public static int solve(int k, int w, int[] profits, int[] capital) {

        int currCap = w;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < profits.length; i++) {
            pq.add(new int[]{profits[i], capital[i]});
        }

        Queue<int[]> q = new LinkedList<>();

        while (k-- > 0) {

            while (true) {
                if (pq.isEmpty()) return currCap;

                int[] ele = pq.poll();
                if (currCap >= ele[1]) {
                    currCap += ele[0];
                    break;
                } else {
                    q.add(ele);
                }
            }
            while (!q.isEmpty()) {
                pq.add(q.poll());
            }
        }
        return currCap;
    }
}
