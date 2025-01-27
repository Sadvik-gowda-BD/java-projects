package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
547. Number of Provinces
 */
public class NumberOfProvences2 {

    public static void main(String[] args) {

        int[][] mat = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int[][] mat2 = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};

        System.out.println(solveByDS(mat2));
    }

    //Disjoint set
    public static int solveByDS(int[][] mat) {

        int len = mat.length;
        DisjointSet ds = new DisjointSet(len);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (mat[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            set.add(ds.findParent(i));
        }
        return set.size();
    }


    public static int solveByBFS(int[][] isConnected) {
        int len = isConnected.length;
        int count = 0;
        int visited[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (visited[i] == 0) {
                count++;
                bfs(isConnected, visited, len, i);
            }
        }
        return count;
    }

    public static void bfs(int isConnected[][], int visited[], int len, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < len; i++) {
                if (visited[i] != 1 && isConnected[node][i] == 1) {
                    visited[i] = 1;
                    q.add(i);
                }
            }
        }
    }
}
