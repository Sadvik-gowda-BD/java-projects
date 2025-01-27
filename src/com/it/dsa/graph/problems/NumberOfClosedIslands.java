package com.it.dsa.graph.problems;


/*
1254. Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water).

 */
public class NumberOfClosedIslands {

    private static boolean isBoundry;

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
                    isBoundry = false;
                    dfs(grid, vis, i, j);
                    if (!isBoundry) {
                        closedIsland++;
                    }
                }
            }
        }

        return closedIsland;
    }

    public static void dfs(int[][] grid, boolean[][] vis, int r, int c) {

        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (r < 0 || r >= rowLen || c < 0 || c >= colLen || grid[r][c] == 1 || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        if (isBoundry(r, c, rowLen, colLen)) {
            isBoundry = true;
        }

        //System.out.println("r:" + r + " c:" + c);

        dfs(grid, vis, r - 1, c);
        dfs(grid, vis, r, c - 1);
        dfs(grid, vis, r + 1, c);
        dfs(grid, vis, r, c + 1);

    }

    private static boolean isBoundry(int r, int c, int rowLen, int colLen) {
        return r == 0 || c == 0 || r == rowLen - 1 || c == colLen - 1;
    }


    //Solution 2
    public static boolean dfs(int[][] grid,int i, int j) {
        int rows = grid.length, cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1; // mark as visited
        boolean left = dfs(grid,i, j-1), right = dfs(grid,i, j+1);
        boolean up = dfs(grid,i-1, j), down = dfs(grid,i+1, j);
        return left && right && up && down;
    }
}
