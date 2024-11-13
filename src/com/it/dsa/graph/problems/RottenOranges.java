package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*994. Rotting Oranges
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
 */
public class RottenOranges {


    public static void main(String[] args) {

        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] grid2 = {
                {1, 2, 1},
                {1, 1, 0},
                {0, 0, 1}
        };

        int result = solve(grid);


        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Result Minute: " + result);
    }

    private static int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxTime = 0;

        int freshOrange = 0;

        boolean[][] vis = new boolean[m][n];

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        Queue<OrangesPair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = true;
                    q.add(new OrangesPair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        while (!q.isEmpty()) {
            OrangesPair pair = q.poll();
            int r = pair.r;
            int c = pair.c;
            int t = pair.t;
            maxTime = Math.max(t, maxTime);

            for (int ind = 0; ind < 4; ind++) {
                int neighbourRow = r + deltaRow[ind];
                int neighbourCol = c + deltaCol[ind];

                if (neighbourRow >= 0 && neighbourRow < grid.length
                        && neighbourCol >= 0 && neighbourCol < grid[0].length
                        && grid[neighbourRow][neighbourCol] == 1
                        && !vis[neighbourRow][neighbourCol]) {

                    vis[neighbourRow][neighbourCol] = true;
                    q.add(new OrangesPair(neighbourRow, neighbourCol, t + 1));
                    freshOrange--;
                }

            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1 && !vis[i][j]) {
//                    return -1;
//                }
//            }
//        }

        if(freshOrange != 0){
            return -1;
        }

        System.out.println(maxTime);
        return maxTime;
    }
}

class OrangesPair {
    public int r, c, t;

    public OrangesPair(int r, int c, int t) {
        this.r = r;
        this.c = c;
        this.t = t;
    }
}