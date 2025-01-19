package com.it.dsa.graph.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Dijkstra Algorithm

It will work for both directed and non-directed graph. But we've to convert non-directed to directed graph.
It won't work for -ve edges
 */
public class DijkstraAlgorithm {


    public static void main(String[] args) {
        //[   [[1, 1], [2, 6]] , [[2, 3], [0, 1]], [[1, 3], [0, 6]]]

        List<List<iPair>> adj = new ArrayList<>();
        adj.add(List.of(new iPair(1, 1), new iPair(2, 6)));
        adj.add(List.of(new iPair(2, 3), new iPair(0, 1)));
        adj.add(List.of(new iPair(1, 3), new iPair(0, 6)));

        int src = 2;
        System.out.println(solveByPq(adj, src));

        List<List<iPair>> adj2 = new ArrayList<>();
        adj2.add(List.of(new iPair(1, 3), new iPair(3, 5)));
        adj2.add(Collections.emptyList());
        adj2.add(List.of(new iPair(1, -10)));
        adj2.add(List.of(new iPair(2, 2)));

        int src2 = 0;
        System.out.println(solveByPq(adj2, src2));
    }

    public static ArrayList<Integer> solveByPq
            (List<List<iPair>> adj, int src) {

        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();

        int[] distArr = new int[V];
        Arrays.fill(distArr, Integer.MAX_VALUE);

        Comparator<iPair> comparator = new Comparator<iPair>() {
            @Override
            public int compare(iPair o1, iPair o2) {
                if (o1.weight != o2.weight) {
                    return o1.weight - o2.weight;
                } else {
                    return o1.node - o2.node;
                }
            }
        };

        PriorityQueue<iPair> pq = new PriorityQueue<>(comparator);
        distArr[src] = 0;

        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()) {

            iPair currPair = pq.poll();
            List<iPair> neigh = adj.get(currPair.node);

            for (iPair p : neigh) {
                int newDist = p.weight + currPair.weight;

                if (newDist < distArr[p.node]) {
                    distArr[p.node] = newDist;
                    pq.add(new iPair(p.node, newDist));
                }
            }
        }

        for (int dist : distArr) {
            ans.add(dist);
        }

        return ans;
    }


    private static class iPair {
        int node;
        int weight;

        public iPair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
