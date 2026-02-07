package com.it.problem_solve.leetcode.others;

import com.it.problem_solve.util.PrintArray;

import java.util.Arrays;

public class DetectCyclicInUndirectedGraph {

    static int[] DIR_X = {1, -1, 0, 0};
    static int[] DIR_Y = {0, 0, 1, -1};

    public static void main(String[] args) {


        char[][] grid1 = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};

        char[][] grid2 = {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}};


        System.out.println(containsCycle(grid1));

    }

    public static boolean containsCycle(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] vis = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j]) {
                    char val = grid[i][j];
                    boolean res = dfs(i, j, -1, -1, rows, cols, vis, grid, val);
                    if (res == true) {
                        return true;
                    }
                }

            }
        }
        return false;
    }



    private static boolean dfs(int curX, int curY, int lastX, int lastY, int n, int m, boolean[][] vis, char[][] grid,
                               char startChar) {
        vis[curX][curY] = true;
        boolean hasCycle = false;
        // Visit all directions
        for (int i = 0; i < 4; ++i) {
            int newX = curX + DIR_X[i];
            int newY = curY + DIR_Y[i];
            // Valid point?
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                // Don't visit last visited point
                if (!(newX == lastX && newY == lastY)) {
                    // Only visit nodes that equal start character
                    if (grid[newX][newY] == startChar) {
                        if (vis[newX][newY]) {
                            // Still visited? There is a cycle.
                            return true;
                        } else {
                            hasCycle |= dfs(newX, newY, curX, curY, n, m, vis, grid, startChar);
                        }
                    }
                }
            }
        }
        return hasCycle;
    }
}
