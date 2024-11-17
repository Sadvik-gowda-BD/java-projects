package com.it.dsa.graph.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {

    }

    private static boolean dfs(List<List<Integer>> adjList) {

        int V = adjList.size();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                boolean result = dfs(adjList, vis, new CyclicPair(i, -1));
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, boolean[] vis, CyclicPair pair) {

        vis[pair.n] = true;
        List<Integer> neighbours = adjList.get(pair.n);

        for (int neigNode : neighbours) {
            if (!vis[neigNode]) {
                boolean result = dfs(adjList, vis, new CyclicPair(neigNode, pair.n));
                if (result){
                    return true;
                }
            } else if (neigNode != pair.from) {
                return true;
            }
        }
        return false;
    }


    private static boolean bfs(List<List<Integer>> adjList) {

        int V = adjList.size();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                Queue<CyclicPair> q = new LinkedList<>();

                q.add(new CyclicPair(i, -1));
                vis[i] = true;
                while (!q.isEmpty()) {
                    CyclicPair pair = q.poll();

                    int parentNode = pair.from;
                    int currNode = pair.n;

                    List<Integer> ls = adjList.get(currNode);
                    for (int neig : ls) {
                        if (!vis[neig]) {
                            vis[neig] = true;
                            q.add(new CyclicPair(neig, currNode));
                        } else if (neig != parentNode) {
                            return true;
                        }
                    }
                }
            }
        }


        return false;
    }

}

class CyclicPair {

    public CyclicPair(int n, int from) {
        this.n = n;
        this.from = from;
    }

    int n;
    int from;
}
