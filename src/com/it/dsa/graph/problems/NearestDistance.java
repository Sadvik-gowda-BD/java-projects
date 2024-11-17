package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
542. 01 Matrix
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
 */
public class NearestDistance {

    public static void main(String[] args) {

        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };


        //Simple and easy solution
        int[][] resultDP = solveBFS1(mat);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(resultDP[i]));
        }

        int[][] result = solveBFS2(mat);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }

    private static int[][] solveBFS1(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int[][] dist = new int[rows][cols];

        Queue<NearDistPair> q = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    q.add(new NearDistPair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] deltaRow = {1, -1, 0, 0};
        int[] deltaCol = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            NearDistPair pair = q.poll();
            dist[pair.r][pair.c] = pair.distance;

            for (int ind = 0; ind < 4; ind++) {
                int neighRow = pair.r + deltaRow[ind];
                int neighCol = pair.c + deltaCol[ind];

                if (neighRow >= 0 && neighCol >= 0 && neighRow < rows && neighCol < cols && !vis[neighRow][neighCol]) {
                    q.add(new NearDistPair(neighRow, neighCol, pair.distance + 1));
                    vis[neighRow][neighCol] = true;
                }

            }
        }

        return dist;
    }

    public static int[][] solveBFS2(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    int n = solveBFS(mat, i, j);
                    res[i][j] = n;
                }
            }
        }

        return res;
    }

    private static int solveBFS(int[][] mat, int r, int c) {

        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] vis = new boolean[rows][cols];

        NearDistPair initialPair = new NearDistPair(r, c, 0);
        Queue<NearDistPair> q = new LinkedList<>();

        q.add(initialPair);

        int[] deltaRow = {1, -1, 0, 0};
        int[] deltaCol = {0, 0, 1, -1};

        while (!q.isEmpty()) {

            NearDistPair pair = q.poll();

            for (int ind = 0; ind < 4; ind++) {
                int neighRow = deltaRow[ind] + pair.r;
                int neighCol = deltaCol[ind] + pair.c;

                if (neighRow >= 0 && neighCol >= 0 && neighRow < rows && neighCol < cols && !vis[neighRow][neighCol]) {
                    if (mat[neighRow][neighCol] == 0) {
                        return pair.distance + 1;
                    }
                    NearDistPair newPair = new NearDistPair(neighRow, neighCol, pair.distance + 1);
                    q.add(newPair);
                }
            }
        }
        return -1;

    }



}

class NearDistPair {

    int r;
    int c;
    int distance;

    public NearDistPair(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}
