package com.it.dsa.graph.algorithms;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalsAlgorithmMinSpanning {

    public static void main(String[] args) {

        int V = 3;
        List<List<int[]>> adj = new ArrayList<>();
        adj.add(Arrays.asList(new int[]{1, 5}, new int[]{2, 1}));
        adj.add(Arrays.asList(new int[]{2, 3}));

        int res = spanningTree(adj, V);
        System.out.println(res);

    }

    static int spanningTree(List<List<int[]>> adj, int V) {

        int minSpanTreeSum = 0;
        List<List<Integer>> mst = new ArrayList<>();

        List<int[]> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new int[3]);
        }

        for (int i = 0; i < adj.size(); i++) {
            for (int[] edge : adj.get(i)) {
                int u = i;
                int v = edge[0];
                int wt = edge[1];
                adjList.add(new int[]{u, v, wt});
                //adjList.add(new int[]{v, u, wt}); optional - not req in disjoint because it discard one edge
            }
        }

        //sort based on weight, so that min weight edge will be picked first
        adjList.sort((o1, o2) -> o1[2] - o2[2]);
        DisjointSet djs = new DisjointSet(V - 1);


        for (int[] edge : adjList) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (!djs.isUVSameComponent(u, v)) {
                djs.unionBySize(u, v);
                minSpanTreeSum += wt;
                mst.add(List.of(u, v));
            }
        }

        return minSpanTreeSum;
    }
}
