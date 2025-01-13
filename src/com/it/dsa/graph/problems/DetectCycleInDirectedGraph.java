package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {

        List<List<Integer>> adjList = List.of(
                List.of(1,2), List.of(2), List.of(0,3), List.of(3)
        );

        System.out.println(solveByDfs(adjList));

        System.out.println(solveByKhanAlgoTopoSort(adjList));

    }

    //This can solve by using BFS topological sort as well

    private static boolean solveByDfs(List<List<Integer>> adjList) {

        boolean[] vis = new boolean[adjList.size()];
        boolean[] pathVis = new boolean[adjList.size()];

        int tNodes = adjList.size();

        for (int i = 0; i < tNodes; i++) {
            if (!vis[i]) {
                boolean result = dfs(i, adjList, vis, pathVis);

                if (result == true) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> adjList, boolean[] vis, boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        List<Integer> neighNodes = adjList.get(node);

        for (int i = 0; i < neighNodes.size(); i++) {

            int nextNode = neighNodes.get(i);

            if (!vis[nextNode]) {
                dfs(nextNode, adjList, vis, pathVis);

            } else if (pathVis[nextNode]) {
                return true;
            }

        }
        pathVis[node] = false;

        return false;
    }

    private static boolean solveByKhanAlgoTopoSort(List<List<Integer>> adjList) {

        int tNodes = adjList.size();
        List<Integer> topoSort = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[tNodes];

        for (List<Integer> neigNodes : adjList) {
            for (int node : neigNodes) {
                inDegree[node]++;
            }
        }

        for (int i = 0; i < tNodes; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int node = q.poll();
            topoSort.add(node);

            for (int neigNode : adjList.get(node)) {
                inDegree[neigNode]--;
                if (inDegree[neigNode] == 0) {
                    q.add(neigNode);
                }
            }
        }

        if (topoSort.size() != tNodes) {
            return true;
        } else {
            return false;
        }
    }
}
