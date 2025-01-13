package com.it.dsa.graph.problems;

import com.it.problem_solve.util.PrintArray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
1091. Shortest Path in Binary Matrix

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 */
public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {

        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};

        int[][] grid2 = {{0, 0, 0}, {1, 0, 0}, {1, 1, 0}};

        System.out.println(solve(grid2));
    }

    // We can use simple Queue instead of PriorityQueue, because all edges having same weight.
    private static int solve(int[][] grid) {

        if (grid[0][0] == 1) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distArr = new int[rows][cols];

        for (int[] arr : distArr) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        distArr[0][0] = 0;

        Queue<Pair> pq = new LinkedList<>();

        pq.add(new Pair(0, 0, 0));

        while (!pq.isEmpty()) {

            Pair currPair = pq.poll();
            int currRow = currPair.i;
            int currCol = currPair.j;

            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {

                    int nexRow = currRow + r;
                    int nextCol = currCol + c;

                     if (nexRow == currRow && nexRow == currCol) {
                         continue;
                     }

                    if (nexRow < rows && nexRow > -1 && nextCol < cols && nextCol > -1 && grid[nexRow][nextCol] == 0) {
                        int newDist = currPair.dist + 1;
                        if (newDist < distArr[nexRow][nextCol]) {
                            distArr[nexRow][nextCol] = newDist;
                            pq.add(new Pair(nexRow, nextCol, newDist));
                        }
                    }

                }
            }
        }

        if (distArr[rows - 1][cols - 1] != Integer.MAX_VALUE) {
            return distArr[rows - 1][cols - 1] + 1;
        }
        return -1;
    }

    private static class Pair {

        int i;
        int j;
        int dist;

        public Pair(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }


}
