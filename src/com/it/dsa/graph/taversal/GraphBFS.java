package com.it.dsa.graph.taversal;

import com.it.dsa.graph.problems.Pair;
import com.it.dsa.graph.representation.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphBFS {

    public static void main(String[] args) {


    }

    private static void bfsForAdjList(List<List<Integer>> adj){
        int nodesSize = adj.size();
        System.out.println(adj);

        boolean[] visited = new boolean[nodesSize];
        Queue<Integer> q = new LinkedList<>();

        System.out.println("\nBFS");

        //took 1 based index
        int startNode = 1;
        q.add(startNode);
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + ", ");

            for (int ele : adj.get(node)) {
                if (!visited[ele]) {
                    visited[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

    private static void bfsForMatrix(int r, int c, char[][] grid, boolean[][] visit) {
        Queue<Pair> pairs = new LinkedList<>();
        Pair pair = new Pair(r, c);
        pairs.add(pair);
        visit[r][c] = true;

        while (!pairs.isEmpty()) {
            Pair currentPair = pairs.poll();
            r = currentPair.r;
            c = currentPair.c;

            //delta row and delta column
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = delRow + r; //neighbor row
                    int nCol = delCol + c; //neighbor col
                    if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length
                            && !visit[nRow][nCol] && grid[nRow][nCol] == '1'
                            && (nRow == r || nCol == c)) {
                        pairs.add(new Pair(nRow, nCol));
                        visit[nRow][nCol] = true;
                    }
                }
            }
        }
    }

}
