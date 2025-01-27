package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {

    public static void main(String[] args) {

        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {
                1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(solve(grid));

    }

    public static int solve(int[][] grid) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        int closedIsland = 0;
        boolean[][] vis = new boolean[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    boolean res = dfs(grid, vis, i, j);
                    if (res) {
                        closedIsland++;
                    }
                }
            }
        }

        return closedIsland;
    }

    public static boolean dfs(int[][] grid, boolean[][] vis, int r, int c) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || grid[r][c] == 1 || vis[r][c]) {
            return true;
        }

        vis[r][c] = true;

        if (isBoundry(r, c, rowLen, colLen)) {
            return false;
        }

        //System.out.println("r:" + r + " c:" + c);

        return dfs(grid, vis, r - 1, c) &&
                dfs(grid, vis, r, c - 1) &&
                dfs(grid, vis, r + 1, c) &&
                dfs(grid, vis, r, c + 1);

    }

    private static boolean isBoundry(int r, int c, int rowLen, int colLen) {
        return r == 0 || c == 0 || r == rowLen - 1 || c == colLen - 1;
    }


}
