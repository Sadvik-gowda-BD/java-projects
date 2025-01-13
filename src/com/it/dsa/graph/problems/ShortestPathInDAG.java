package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathInDAG {

    public static void main(String[] args) {

        int[][] graph1 = {{0, 1, 2}, {0, 2, 1}};
        int V1 = 4;

        int[][] graph2 = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int V2 = 6;

        int[] res = solveByBruteforce(graph1, V1);

        System.out.println("Brutefore");
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(solveByBruteforce(graph2, V2)));

        System.out.println("\nBy Topological sort");
        System.out.println(Arrays.toString(solve(graph1, V1, 0)));
        System.out.println(Arrays.toString(solve(graph2, V2, 0)));
    }


    //Solve by using topological sort
    private static int[] solve(int[][] graph, int V, int src) {

        Stack<Integer> topoSort = new Stack<>();

        boolean[] vis = new boolean[V];

        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : graph) {
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];

            adjList.get(from).add(new Pair(to, weight));
        }

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSortDfs(adjList, i, topoSort, vis);
            }
        }

        int[] distArr = new int[V];

        Arrays.fill(distArr, Integer.MAX_VALUE);

        distArr[src] = 0;

        while (!topoSort.isEmpty()) {
            int fromNode = topoSort.pop();
            if (distArr[fromNode] == Integer.MAX_VALUE) {
                continue;
            }

            List<Pair> neighNodes = adjList.get(fromNode);
            for (Pair nodepair : neighNodes) {
                int toNode = nodepair.to;
                int newDist = distArr[fromNode] + nodepair.weight;
                distArr[toNode] = Math.min(distArr[toNode], newDist);
            }
        }

        for (int i = 0; i < V; i++) {
            if (distArr[i] == Integer.MAX_VALUE) {
                distArr[i] = -1;
            }
        }

        return distArr;
    }

    public static void topoSortDfs(List<List<Pair>> graph, int node, Stack<Integer> topoSort, boolean[] vis) {

        vis[node] = true;

        List<Pair> neighNodes = graph.get(node);

        for (Pair nodePair : neighNodes) {
            int n = nodePair.to;
            if (!vis[n]) {
                topoSortDfs(graph, n, topoSort, vis);
            }
        }

        topoSort.push(node);
    }

    private static class Pair {

        int to;
        int weight;

        public Pair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    //Time complexity is more
    private static int[] solveByBruteforce(int[][] graph, int V) {


        List<List<List<Integer>>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : graph) {
            int from = arr[0];
            int to = arr[1];
            int weight = arr[2];

            adjList.get(from).add(List.of(to, weight));
        }

        int[] res = bfs(adjList, V);

        for (int i = 0; i < V; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                res[i] = -1;
            }
        }

        return res;
    }

    private static int[] bfs(List<List<List<Integer>>> adjList, int V) {

        Queue<PathPair> q = new LinkedList<>();
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        List<List<Integer>> startNode = adjList.get(0);

        q.add(new PathPair(0, 0));

        while (!q.isEmpty()) {

            PathPair currNode = q.poll();

            dist[currNode.node] = Math.min(dist[currNode.node], currNode.totalDist);

            List<List<Integer>> neigNodes = adjList.get(currNode.node);

            for (List<Integer> ls : neigNodes) {
                int nextNode = ls.get(0);
                int weig = ls.get(1) + currNode.totalDist;
                q.add(new PathPair(nextNode, weig));
            }
        }

        return dist;

    }

    private static class PathPair {
        public PathPair(int node, int totalDist) {
            this.node = node;
            this.totalDist = totalDist;
        }

        int node;
        int totalDist;
    }

}

