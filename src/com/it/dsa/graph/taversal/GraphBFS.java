package com.it.dsa.graph.taversal;

import com.it.dsa.graph.representation.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    public static void main(String[] args) {

        List<List<Integer>> adj = Graph.adjList;
        int nodesSize = adj.size();

        System.out.println(adj);

        boolean[] visited = new boolean[nodesSize];

        Queue<Integer> q = new LinkedList<>();

        System.out.println("\nBFS");

        //took 1 based index
        int startNode = 1;
        q.add(startNode);
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + ", ");

            for (int ele : adj.get(node)) {
                if (!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

}
