package com.it.dsa.graph.problems;

/*
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

//200. Number of Islands
 */

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland {

    public static void main(String[] args) {

        int[][] mat = {
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };

        int ans = solve(mat);
        System.out.println(ans);
    }

    private static int solve(int[][] mat) {

        boolean[][] visited = new boolean[mat.length][mat[0].length];

        int row = mat.length;
        int col = mat[0].length;

        int island = 0;
        int rowLen = mat.length;
        int colLen = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && mat[i][j] == 1) {
                    island++;
                    traverseDFS(mat, visited, i, j, rowLen, colLen);
                }
            }
        }
        return island;
    }

    private static void traverseDFS(int[][] mat, boolean[][] visited, int i, int j, int rowLen, int colLen) {

        //System.out.println(i + " " + j);
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || mat[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        if (mat[i][j] == 1) {
            //visited[i][j] = true;

            traverseDFS(mat, visited, i - 1, j, rowLen, colLen);
            traverseDFS(mat, visited, i + 1, j, rowLen, colLen);
            traverseDFS(mat, visited, i, j - 1, rowLen, colLen);
            traverseDFS(mat, visited, i, j + 1, rowLen, colLen);

            // Diagonal condition
//            traverseDFS(mat, visited, i - 1, j - 1, rowLen, colLen);
//            traverseDFS(mat, visited, i - 1, j + 1, rowLen, colLen);
//            traverseDFS(mat, visited, i + 1, j + 1, rowLen, colLen);
//            traverseDFS(mat, visited, i + 1, j + 1, rowLen, colLen);
        }

    }

    private static void bfs(int r, int c, char[][] grid, boolean[][] visit) {
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

