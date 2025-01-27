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



     private static void dfsForMatrix(int[][] mat, boolean[][] visited, int i, int j, int rowLen, int colLen) {

        //System.out.println(i + " " + j);
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || mat[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        if (mat[i][j] == 1) {
            //visited[i][j] = true;

            dfsForMatrix(mat, visited, i - 1, j, rowLen, colLen);
            dfsForMatrix(mat, visited, i + 1, j, rowLen, colLen);
            dfsForMatrix(mat, visited, i, j - 1, rowLen, colLen);
            dfsForMatrix(mat, visited, i, j + 1, rowLen, colLen);

            // Diagonal condition
//            traverseDFS(mat, visited, i - 1, j - 1, rowLen, colLen);
//            traverseDFS(mat, visited, i - 1, j + 1, rowLen, colLen);
//            traverseDFS(mat, visited, i + 1, j + 1, rowLen, colLen);
//            traverseDFS(mat, visited, i + 1, j + 1, rowLen, colLen);
        }

    }



}
