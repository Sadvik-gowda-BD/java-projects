package com.it.dsa.graph.taversal;

import com.it.dsa.graph.representation.Graph;

import java.util.List;

public class GraphDFS {

    public static void main(String[] args) {
        List<List<Integer>> adj = Graph.adjList;
        int nodesSize = adj.size();

        boolean[] visited = new boolean[nodesSize];
        int startNode = 1;

        System.out.println("\nDFS: ----------------------");
        dfsRec(adj, visited, startNode);

    }

    private static void dfsRec(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node+", ");

        List<Integer> degrees = adj.get(node);
        for (int n : degrees) {
            if (!visited[n]) {
                dfsRec(adj, visited, n);
            }
        }

    }


}
