package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Code 360
Problem statement
Given a matrix of integers ‘ARR’ with ‘R’ rows and ‘C’ columns, find the maximum score of a path starting at [0, 0] and ending at [R-1, C-1]. The score of a path is the minimum value in that path. For example, the value of the path 8 -> 4 -> 5 -> 9 is 4. A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).

Example:
Let’s say we have ARR = { {5 4 5} , {1 2 6} , {7 4 6}} so the path with
maximum value will be 5 -> 4 -> 5 -> 6 -> 6 and we have to return
the minimum value in this path as the answer i.e 4.
 */
public class PathWithMaximumAndMinimumValue {

    public static int solve(ArrayList<ArrayList<Integer>> arr) {

        int tRows = arr.size();
        int tCols = arr.get(0).size();

        boolean[][] vis = new boolean[tRows][tCols];

        PriorityQueue<Pair> pq = new PriorityQueue<>(((o1, o2) -> o2.weight - o1.weight));

        pq.add(new Pair(0, 0, arr.get(0).get(0)));
        vis[0][0] = true;
        int min = arr.get(0).get(0);

        while (!pq.isEmpty()) {

            Pair node = pq.poll();

            System.out.println(node);

            min = Math.min(min, node.weight);
            if (node.r == tRows - 1 && node.c == tCols - 1) return min;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int dRow = node.r + i;
                    int dCol = node.c + j;

                    if (dRow < 0 || dCol < 0 || dRow >= tRows || dCol >= tCols || vis[dRow][dCol] || (dRow != node.r && dCol != node.c)) {
                        continue;
                    }
                    pq.add(new Pair(dRow, dCol, arr.get(dRow).get(dCol)));
                    vis[dRow][dCol] = true;
                }
            }
        }

        return min;
    }


    private static class Pair {
        int r;
        int c;
        int weight;

        public Pair(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

    }

}
