package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
787. Cheapest Flights Within K Stops

Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
 */
public class FlightWithKStops {

    public static void main(String[] args) {

        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(solve(n, flights, src, dst, k));

    }

    public static int solve(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : flights) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];

            adjList.get(from).add(new Pair(to, cost));
        }

        int[] distArr = new int[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);

        distArr[src] = 0;

        Queue<QPair> q = new LinkedList<>();
        q.add(new QPair(src, 0, -1));

        while (!q.isEmpty()) {

            QPair node = q.poll();

            int currCost = node.weight;
            int currStop = node.stop;

            for (Pair pair : adjList.get(node.node)) {

                int newStop = currStop + 1;
                int newCost = currCost + pair.wight;

                if (newCost < distArr[pair.to]) {
                    if (pair.to == dst && newStop <= k) {
                        distArr[pair.to] = newCost;
                    } else if (pair.to != dst) {
                        distArr[pair.to] = newCost;
                    }
                    q.add(new QPair(pair.to, newCost, newStop));
                }

            }
        }

//        System.out.println(Arrays.toString(distArr));

        return distArr[dst] == Integer.MAX_VALUE ? -1 : distArr[dst];
    }


    static class Pair {

        public Pair(int to, int wight) {
            this.to = to;
            this.wight = wight;
        }

        int to;
        int wight;
    }

    static class QPair {

        public QPair(int node, int weight, int stop) {
            this.node = node;
            this.weight = weight;
            this.stop = stop;
        }

        int node;
        int weight;
        int stop;
    }


}
