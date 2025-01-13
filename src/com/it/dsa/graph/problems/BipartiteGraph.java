package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) {

        int[][] ip = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};

        int[][] ip2 = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartite(ip2));

    }

    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                boolean res = solveByDfs(i, 1, vis, graph);
                if (res == false) {
                    return false;
                }
            }
        }

        //System.out.println(Arrays.toString(vis));

        return true;
    }

    public static boolean solveByBfs(int node, int colour, int[] vis, int[][] graph) {

        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        vis[node] = colour;

        while (!q.isEmpty()) {
            int val = q.poll();
            int nextCol = (vis[val] == 1 ? 2 : 1);

            for (int n : graph[val]) {

                //vis[n] == 0 means it is visited
                if (vis[n] != 0 && vis[n] != nextCol) {
                    return false;
                } else if (vis[n] != 0) {
                    continue;
                }

                vis[n] = nextCol;
                q.add(n);
            }

        }

        return true;

    }

    public static boolean solveByDfs(int node, int colour, int[] vis, int[][] graph) {

        if (vis[node] == 0) {
            vis[node] = colour;

            for (int n : graph[node]) {
                int nextCol = (vis[node] == 1 ? 2 : 1);
                boolean res = solveByDfs(n, nextCol, vis, graph);
                if (res == false) {
                    return false;
                }
            }
        } else if (vis[node] != colour) {
            return false;
        }

        return true;
    }


}
