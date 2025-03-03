package com.it.dsa.graph.algorithms;

/*
The Floyd Warshall Algorithm is an all pair shortest path algorithm

The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph.
The graph is represented as an adjacency matrix. mat[i][j] denotes the weight of the edge from i to j. If mat[i][j] = -1, it means there is no edge from i to j.
Note: Modify the distances for every pair in place.
 */
public class FloydWarshall {

    public static void main(String[] args) {
        //input matrix, if there is no path then mat[i][j]=-1.
    }

    public void shortestDistance(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
                //distance from node_x to node_x is 0
                if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        //move via k node
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                    }
                }
            }
        }

        //check negative cycle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && mat[i][j] != 0) {
                    System.out.println("Negative cycle exist");
                }
            }
        }

    }
}
