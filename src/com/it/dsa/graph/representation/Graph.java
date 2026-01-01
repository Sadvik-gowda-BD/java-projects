package com.it.dsa.graph.representation;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static List<List<Integer>> adjList = adjacentList();

    public static void main(String[] args) throws Exception {

        adjacentMatrix();
        adjacentList();
    }


    public static List<List<Integer>> adjacentList() {
        // Create a graph with 4 vertices and no edges
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 5, 4);

        System.out.println("\n\nAdjacency List Representation:");
        displayAdjList(adj);

        return adj;

    }

    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adj.get(i)) {
                System.out.print(j + " "); // Print its adjacent
            }
            System.out.println();
        }
    }

    public static void addEdge(List<List<Integer>> adj, int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i); // Undirected
    }

    public static int[][] adjacentMatrix() {
        // Create a graph with 4 vertices and no edges
        // Note that all values are initialized as 0
        int V = 5;
        int[][] adj = new int[V + 1][V + 1];

        // Now add edges one by one
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 5, 4);

        System.out.println("\n\nAdjacency Matrix Representation");
        displayMatrix(adj);
        return adj;
    }

    private static void addEdge(int[][] adj, int i, int j) {
        adj[i][j] = 1;
        adj[j][i] = 1;
    }

    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    /*
    Representation of Wighted graph on Adjacent list.
    List<List<Pair>> adj; //better to use
    or List<List<int[]>> adj;   // int[]{to, weight}
    or use Map
     */
    private static void representWeightedDirectedGraph() {

        int V = 4;

        List<List<iPair>> adjListWithPairObj = new ArrayList<>(); //List<List<Pair>> adj; //better to use
        List<List<int[]>> adjListWithArr = new ArrayList<>(); //List<List<int[]>> adj;   // int[]{to, weight}

        for (int i = 0; i < V; i++) {
            adjListWithPairObj = new ArrayList<>();
            adjListWithArr = new ArrayList<>();
        }

        addWeightedEdgesPair(0, 1, 3, adjListWithPairObj); // 0 ---3---> 1
        addWeightedEdgesPair(0, 2, 4, adjListWithPairObj); // 0 ---4---> 2

        addWeightedEdgesArr(0, 1, 3, adjListWithArr);
        addWeightedEdgesArr(0, 2, 4, adjListWithArr);
    }

    private static void addWeightedEdgesPair(int u, int v, int weight, List<List<iPair>> list) {
        list.get(u).add(new iPair(v, weight));
    }

    private static void addWeightedEdgesArr(int u, int v, int weight, List<List<int[]>> list) {
        list.get(u).add(new int[]{v, weight});
    }


    private static class iPair {
        int to;
        int weight;

        public iPair(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
