package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
It is only applicable for DAG (Directed Acyclic Graph)
 */
public class TopologicalSort {

    public static void main(String[] args) {

        int[][] adjArray = {
                {}, {3}, {3}, {}, {0, 1}, {0, 2}
        };


        int[] res = solveByDfs(adjArray);

        /*
        op is
        [4, 5, 0, 1, 2, 3]  or
        [5, 2, 4, 0, 1, 3] or etc
         */
        System.out.println(Arrays.toString(res));
    }


    private static int[] solveByDfs(int[][] adjArray) {

        int tNodes = adjArray.length;

        boolean[] vis = new boolean[tNodes];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tNodes; i++) {
            if (!vis[i]) {
                dfs(i, adjArray, vis, st);
            }
        }

        int[] ans = new int[tNodes];
        int index = 0;

        while (!st.isEmpty()) {
            ans[index++] = st.pop();
        }

        return ans;
    }

    private static void dfs(int node, int[][] adjArray, boolean[] vis, Stack<Integer> st) {

        vis[node] = true;

        for (int n : adjArray[node]) {
            if (!vis[n]) {
                dfs(n, adjArray, vis, st);
            }
        }

        st.push(node);
    }

    private static int[][] convertListToArray(List<List<Integer>> lists) {

        int[][] adjArr = new int[lists.size()][];

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> currLs = lists.get(i);
            int[] arr = new int[currLs.size()];

            for (int j = 0; j < currLs.size(); j++) {
                arr[j] = currLs.get(j);
            }
            adjArr[i] = arr;
        }

        return adjArr;
    }
}
