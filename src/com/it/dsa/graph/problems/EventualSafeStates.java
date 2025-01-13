package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.List;

/*
802. Find Eventual Safe States
 */
public class EventualSafeStates {

    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        List<Integer> res = solve(graph);

        System.out.println(res);
    }

    /*
    solve-2
    We can do with BFS topo sort as well by using Khan's algo. But we have to reverse the graph and then apply logic.
     */

    public static List<Integer> solve(int[][] graph) {

        int tNodes = graph.length;

        boolean[] vis = new boolean[tNodes];
        boolean[] pathVis = new boolean[tNodes];

        boolean[] safeState = new boolean[tNodes];

        for (int i = 0; i < graph.length; i++) {

            if (!vis[i]) {
                dfsIsCyclic(i, graph, vis, pathVis, safeState);
            }
        }

        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < tNodes; i++) {
            if (safeState[i]) {
                ls.add(i);
            }

        }
        return ls;
    }

    private static boolean dfsIsCyclic(int node, int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] state) {

        vis[node] = true;
        pathVis[node] = true;

        for (int n : graph[node]) {

            if (!vis[n]) {
                boolean res = dfsIsCyclic(n, graph, vis, pathVis, state);
                if (res) {
                    return true;
                }
            } else if (pathVis[n]) {
                return true;
            }
        }

        state[node] = true;
        pathVis[node] = false;
        return false;
    }


}
