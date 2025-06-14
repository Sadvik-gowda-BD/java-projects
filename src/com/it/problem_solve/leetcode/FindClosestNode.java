package com.it.problem_solve.leetcode;


import java.util.Arrays;

//2359. Find Closest Node to Given Two Nodes
public class FindClosestNode {

    public static void main(String[] args) {

    }

    public static int solve(int[] edges, int node1, int node2) {
        int len = edges.length;
        int[] node1Dist = new int[len];
        int[] node2Dist = new int[len];

        Arrays.fill(node1Dist, -1);
        Arrays.fill(node2Dist, -1);

        dfs(edges, node1, node1Dist, 0);
        dfs(edges, node2, node2Dist, 0);

        System.out.println(Arrays.toString(node1Dist));
        System.out.println(Arrays.toString(node2Dist));

        int dist = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < len; i++) {
            if (node1Dist[i] == -1 || node2Dist[i] == -1) {
                continue;
            }
            int currDist = Math.max(node1Dist[i], node2Dist[i]);
            if (currDist < dist) {
                dist = currDist;
                node = i;
            }

        }
        return node;
    }

    private static void dfs(int[] edges, int node, int[] distArr, int dis) {

        if (node == -1 || distArr[node] != -1) return;

        distArr[node] = dis;
        dfs(edges, edges[node], distArr, dis + 1);
    }
}
