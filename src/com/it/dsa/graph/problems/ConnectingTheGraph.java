package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

Connecting the graph

1319. Number of Operations to Make Network Connected

 */
public class ConnectingTheGraph {

    public static void main(String[] args) {

        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};

        int n2 = 6;
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};

        System.out.println(solve(n2, edges2));
    }

    public static int solve(int n, int[][] edges) {

        DisjointSet ds = new DisjointSet(n);
        List<int[]> extraEdges = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!ds.isUVSameComponent(u, v)) {
                ds.unionBySize(u, v);
            } else {
                extraEdges.add(new int[]{u, v});
            }
        }

        int components =0;
        for (int i = 0; i < n; i++) {
            if(ds.findParent(i) == i){
                components++;
            }
        }

        if (extraEdges.size() >= components - 1) {
            return components - 1;
        }
        return -1;
    }


}
