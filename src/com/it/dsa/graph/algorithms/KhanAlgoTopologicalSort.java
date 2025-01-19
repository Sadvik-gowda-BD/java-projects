package com.it.dsa.graph.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Khan algo uses BFS,
If topology contains less than node elements then it is not a DAG (Directed Acyclic Graph).
 */
public class KhanAlgoTopologicalSort {

    public static void main(String[] args) {

        int[][] adjArray = {
                {1, 2}, {2, 3}, {4}, {4}, {}
        };
        int[][] adjArray2 = {
                {9, 8}, {3, 4}, {7, 5}, {4, 5}, {5, 2}, {2, 1}, {6, 0}, {4, 0}, {2, 0}, {1, 0}
        };

        List<Integer> res = solveByBfs(adjArray);
        System.out.println(res);

        //negative case, there is a cyclic, so topo sort array size != tNodes
        int[][] adjArray3 = {
                {1,2}, {2}, {0,3}, {3}
        };
        System.out.println(solveByBfs(adjArray3));
    }

    private static ArrayList<Integer> solveByBfs(int[][] adjArray) {

        int tNodes = adjArray.length;
        int[] inDegree = getInDegree(adjArray);

//        System.out.println("IN degre: " + Arrays.toString(inDegree));

        //In queue store only the node which has in degree zero
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topologicalSort = new ArrayList<>();

        for (int n = 0; n < tNodes; n++) {
            if (inDegree[n] == 0) {
                q.add(n);
            }
        }

        while (!q.isEmpty()) {

            int node = q.poll();
            topologicalSort.add(node);

            for (int adjNode : adjArray[node]) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        return topologicalSort;
    }

    private static int[] getInDegree(int[][] adjArray) {
        int tNodes = adjArray.length;
        int[] nDegree = new int[tNodes];

        for (int[] arr : adjArray) {
            for (int n : arr) {
                nDegree[n]++;
            }
        }
        return nDegree;
    }


}
