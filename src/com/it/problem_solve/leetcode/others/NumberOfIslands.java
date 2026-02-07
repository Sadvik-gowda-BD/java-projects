package com.it.problem_solve.leetcode.others;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        System.out.println(noOfIslands(grid));

    }

    private static int noOfIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        boolean[][] visit = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!visit[r][c] && grid[r][c] == 1) {
                    bfs(r, c, grid, visit);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int r, int c, int[][] grid, boolean[][] visit) {
        Queue<Pair> pairs = new LinkedList<>();
        Pair pair = new Pair(r, c);
        pairs.add(pair);
        visit[r][c] = true;

        while (!pairs.isEmpty()) {
            Pair currentPair = pairs.poll();
            r = currentPair.r;
            c = currentPair.c;
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nRow = delRow + r;
                    int nCol = delCol + c;
                    if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length
                            && !visit[nRow][nCol] && grid[nRow][nCol] == 1 && (nRow == r || nCol == c)) {
                        pairs.add(new Pair(nRow, nCol));
                        visit[nRow][nCol] = true;
                    }
                }
            }
        }

    }

    private void dfsApproach2(char[][] grid, int i, int j){
        if(i < 0 || i >=grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        dfsApproach2(grid, i + 1, j);
        dfsApproach2(grid, i - 1, j);
        dfsApproach2(grid, i, j + 1);
        dfsApproach2(grid, i, j - 1);
    }

}

class Pair {
    public int r, c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
