package com.it.dsa.graph.problems;

import com.it.problem_solve.util.PrintArray;

/*
1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance

 */
public class FindTheCity {

    public static void main(String[] args) {

        int n = 5, distanceThreshold = 2;
        int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int result = solve(n, edges, distanceThreshold);

        System.out.println(result);

        int n2 = 4, distanceThreshold2 = 4;
        int[][] edges2 = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};

        System.out.println(solve(n2, edges2, distanceThreshold2));
    }

    //By using Floyd Warshall algorithm
    public static int solve(int n, int[][] edges, int distanceThreshold) {

        int[][] distArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    distArr[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            distArr[u][v] = wt;
            distArr[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distArr[i][k] != Integer.MAX_VALUE && distArr[k][j] != Integer.MAX_VALUE) {
                        distArr[i][j] = Math.min(distArr[i][j], (distArr[i][k] + distArr[k][j]));
                    }
                }
            }
        }

        //PrintArray.printArray(mat);

        int count = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (distArr[i][j] <= distanceThreshold) {
                    temp++;
                }
            }
            if (temp < count) {
                node = i;
                count = temp;
            } else if (temp == count && i > node) {
                node = i;
            }
        }

        return node;
    }
}
