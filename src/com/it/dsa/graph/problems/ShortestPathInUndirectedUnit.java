package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedUnit {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 3)),
                        new ArrayList<>(Arrays.asList(0, 2)),
                        new ArrayList<>(Arrays.asList(1, 6)),
                        new ArrayList<>(Arrays.asList(0, 4)),
                        new ArrayList<>(Arrays.asList(3, 5)),
                        new ArrayList<>(Arrays.asList(4, 6)),
                        new ArrayList<>(Arrays.asList(2, 5, 7, 8)),
                        new ArrayList<>(Arrays.asList(6, 8)),
                        new ArrayList<>(Arrays.asList(7, 6))
                )
        );

        int src = 0;

        System.out.println(Arrays.toString(solve(adjList, src)));

        System.out.println("\nSolve by using pairs");
        System.out.println(Arrays.toString(solveByUsingPair(adjList, src)));

    }

    private static int[] solve(ArrayList<ArrayList<Integer>> adj, int src) {

        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int n : adj.get(node)) {

                int newDist = dist[node] + 1;

                if (newDist < dist[n]) {
                    q.add(n);
                    dist[n] = newDist;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    private static int[] solveByUsingPair(ArrayList<ArrayList<Integer>> adj, int src) {

        int V = adj.size();
        int[] distArray = new int[V];

        Arrays.fill(distArray, Integer.MAX_VALUE);

        Queue<Pair> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];

        queue.add(new Pair(src, 0));
        vis[src] = true;

        while (!queue.isEmpty()) {

            Pair currPair = queue.poll();
            ArrayList<Integer> neigNodes = adj.get(currPair.node);
            distArray[currPair.node] = currPair.dist;

            for (int n : neigNodes) {
                if (!vis[n]) {
                    vis[n] = true;
                    queue.add(new Pair(n, (currPair.dist + 1)));
                }
            }

        }

        for (int i = 0; i < V; i++) {
            if (distArray[i] == Integer.MAX_VALUE) {
                distArray[i] = -1;
            }
        }

        return distArray;

    }

    private static class Pair {
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        int node;
        int dist;
    }
}
