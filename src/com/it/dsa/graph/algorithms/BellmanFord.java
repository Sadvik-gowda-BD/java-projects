package com.it.dsa.graph.algorithms;

import java.util.Arrays;

/*
GFG

Input: edges = [[0,1,5], [1,0,3], [1,2,-1], [2,0,1]], src = 2

Find the shortest path
Works for negative edges

 */
public class BellmanFord {

    public static void main(String[] args) {

        int[][] edges = {{0, 1, 5}, {1, 0, 3}, {1, 2, -1}, {2, 0, 1}};
        int src = 2;
        int V = 3;
        int[] result = bellmanFord(V, edges, src);

        System.out.println(Arrays.toString(result));
    }

    static int[] bellmanFord(int V, int[][] edges, int src) {

        int MAX = 100000000;
        int[] distArray = new int[V];

        Arrays.fill(distArray, MAX);
        distArray[src] = 0;

        //Do relaxation of V-1 time
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (distArray[u] != MAX && (distArray[u] + wt) < distArray[v]) {
                    distArray[v] = distArray[u] + wt;
                }
            }
        }

        //Relaxation Vth time to check negative cycles, if its able relax then negative cycle is exits
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (distArray[v] != MAX && (distArray[u] + wt) < distArray[v]) {
                return new int[]{-1};
            }
        }
        return distArray;
    }
}
