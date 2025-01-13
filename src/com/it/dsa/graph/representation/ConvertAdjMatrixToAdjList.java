package com.it.dsa.graph.representation;

import java.util.ArrayList;
import java.util.List;

public class ConvertAdjMatrixToAdjList {

    public static void main(String[] args) {

        int[][] adjMatrix = Graph.adjacentMatrix();

        List<List<Integer>> adjList = convertToAdjList(adjMatrix);

        System.out.println(adjList);
    }

    private static List<List<Integer>> convertToAdjList(int[][] adjMatrix) {
        List<List<Integer>> adjList = new ArrayList<>();
        int V = adjMatrix.length;

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjMatrix[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        return adjList;
    }


}
