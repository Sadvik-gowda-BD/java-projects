package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.Graph;

import java.util.List;

public class NumberOfProvences {

    public static void main(String[] args) {
        solve();
    }


    private static void solve() {
        List<List<Integer>> adjList = Graph.adjacentList();

        int noOfV = adjList.size();

        boolean[] visited = new boolean[noOfV];

        int noOfProvence = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                noOfProvence++;
                dfs(adjList, visited, i);
            }
        }
        System.out.println("No of provinces: " + noOfProvence);
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        visited[node] = true;
        for (int n : adjList.get(node)) {
            if (!visited[n]) {
                dfs(adjList, visited, n);
            }
        }
    }
}
