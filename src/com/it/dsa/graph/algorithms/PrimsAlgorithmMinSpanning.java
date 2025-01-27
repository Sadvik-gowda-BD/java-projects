package com.it.dsa.graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*

It uses Greedy approach

Prim's algo is faster than  Kruskal's algo
 */
public class PrimsAlgorithmMinSpanning {

    public static void main(String[] args) {

        int V = 3;
        List<List<int[]>> adj = new ArrayList<>();
        adj.add(Arrays.asList(new int[]{1, 5}, new int[]{2, 1}));
        adj.add(Arrays.asList(new int[]{2, 3}));

        int res = spanningTree(V, 0, adj);
        System.out.println(res);

    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        boolean[] visArr = new boolean[V];
        List<List<Integer>> mst = new ArrayList<>();
        int minSpanTreeSum = 0;

        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < adj.size(); i++) {
            for (int[] edge : adj.get(i)) {
                int u = i;
                int v = edge[0];
                int wt = edge[1];
                adjList.get(u).add(new Pair(v, wt));
                adjList.get(v).add(new Pair(u, wt));
            }
        }

        PqPair initial = new PqPair(0, -1, 0);

        PriorityQueue<PqPair> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        pq.add(initial);

        //TC O(E) + E log E (for priority queue) => E log E
        while (!pq.isEmpty()) {
            PqPair pair = pq.poll();

            if (visArr[pair.node]) {
                continue;
            }

            visArr[pair.node] = true;
            minSpanTreeSum += pair.weight;
            if (pair.parent != -1) {
                mst.add(List.of(pair.parent, pair.node));
            }

            List<Pair> neighNodes = adjList.get(pair.node);
            for (Pair p : neighNodes) {
                if (!visArr[p.to]) {
                    pq.add(new PqPair(p.to, pair.node, p.weight));
                }
            }
        }
        return minSpanTreeSum;
    }

    private static class Pair {
        int to;
        int weight;

        public Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static class PqPair {
        int node;
        int parent;
        int weight;

        public PqPair(int node, int parent, int weight) {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }
    }
}
