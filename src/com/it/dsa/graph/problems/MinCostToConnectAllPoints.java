package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
1584. Min Cost to Connect All Points

u are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 */
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {

        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};

        System.out.println(solve(points));

    }

    public static int solve(int[][] points) {

        //take each point as one node

        int N = points.length;

        List<List<int[]>> adjList = new ArrayList<>();
        boolean[] vis = new boolean[N];

        int ansSum = 0;

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int src = i;
            int xi = points[i][0];
            int yi = points[i][1];
            for (int j = i + 1; j < N; j++) {
                int dest = j;
                int xj = points[j][0];
                int yj = points[j][1];
                int manDist = Math.abs(xi - xj) + Math.abs(yi - yj); //|xi - xj| + |yi - yj|
                adjList.get(src).add(new int[]{dest, manDist});
                adjList.get(dest).add(new int[]{src, manDist});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int node = p[0];

            if (vis[node] == true) {
                continue;
            }
            vis[node] = true;

            ansSum += p[1];

            for (int[] neigh : adjList.get(node)) {
                if (!vis[neigh[0]]) {
                    pq.add(neigh);
                }
            }
        }
        return ansSum;
    }


}
