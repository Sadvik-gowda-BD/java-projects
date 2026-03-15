package com.it.problem_solve.leetcode.others2;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//3600. Maximize Spanning Tree Stability with Upgrades
public class MaximizeSpanningTreeStable {

    private static int solveByPrimsAlg(int n, int[][] edges, int k) {

        List<List<int[]>> adjList = new ArrayList<>();

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int m1 = o1[2];
                int m2 = o2[2];
                if (m1 == 1 || m2 == 1) {
                    if (m1 == 1) {
                        return -1;
                    }
                    return 1;
                }
                return o2[1] - o1[1];
            }
        };
        Queue<int[]> pq = new PriorityQueue<>(comp);

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        int mustEdgeCount = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int st = edge[2];
            int m = edge[3];

            int[] e1 = new int[]{v, st, m};
            int[] e2 = new int[]{u, st, m};
            adjList.get(u).add(e1);
            adjList.get(v).add(e2);
            if (m == 1) {
                mustEdgeCount++;
            }
        }

        int[] initial = new int[]{0, -1, -1};
        pq.add(initial);

        List<int[]> mst = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int visitedMustEdgeCount = 0;

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();

            if (vis[edge[0]]) {
                continue;
            } else {
                if (edge[2] == 1) {
                    visitedMustEdgeCount++;
                }
            }

            vis[edge[0]] = true;
            if (edge != initial) {
                mst.add(new int[]{edge[1], edge[2]});
            }

            List<int[]> neigh = adjList.get(edge[0]);
            for (int[] ne : neigh) {
                if (!vis[ne[0]]) {
                    pq.add(ne);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                return -1;
            }
        }

        if (visitedMustEdgeCount < mustEdgeCount) return -1;

        Comparator<int[]> comp2 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        mst.sort(comp2);

        int min = Integer.MAX_VALUE;

        for (int[] val : mst) {
            if (val[1] == 0 && k > 0) {
                min = Math.min(min, (val[0] * 2));
                k--;
            } else {
                min = Math.min(min, val[0]);
            }

        }

        return min;
    }


    private static int solveByKruskalDisjointSet(int n, int[][] intEdges, int k) {

        int rows = intEdges.length;
        Integer[][] edges = new Integer[rows][4];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 4; j++) {
                edges[i][j] = intEdges[i][j];
            }
        }

        Comparator<Integer[]> comp1 = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int m1 = o1[3];
                int m2 = o2[3];

                if (m1 == 1 || m2 == 1) {
                    if (m1 == 1) {
                        return -1;
                    }
                    return 1;
                }

                return o2[2] - o1[2];
            }
        };

        Arrays.sort(edges, comp1);
        List<int[]> mst = new ArrayList<>();

        DisjointSet ds = new DisjointSet(n);
        for (Integer[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            int must = arr[3];

            if (ds.isUVSameComponent(u, v) && must == 1) {
                return -1;
            }

            if (!ds.isUVSameComponent(u, v)) {
                ds.unionBySize(u, v);
                mst.add(new int[]{wt, must});
            }
        }

        for (int i = 1; i < n; i++) {
            if (!ds.isUVSameComponent(0, i)) {
                return -1;
            }
        }

        Comparator<int[]> comp2 = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        mst.sort(comp2);

        int min = Integer.MAX_VALUE;

        for (int[] val : mst) {
            if (val[1] == 0 && k > 0) {
                min = Math.min(min, (val[0] * 2));
                k--;
            } else {
                min = Math.min(min, val[0]);
            }

        }

        return min;
    }

}
