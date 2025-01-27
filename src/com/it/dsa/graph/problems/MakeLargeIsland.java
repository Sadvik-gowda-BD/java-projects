package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.HashSet;
import java.util.Set;

/*
827. Making A Large Island
 */
public class MakeLargeIsland {

    public static void main(String[] args) {

        int[][] grid1 = {{1, 0}, {0, 1}};
        int[][] grid2 = {{1, 1}, {1, 0}};
        int[][] grid3 = {{1, 1}, {1, 1}};

        System.out.println(solve(grid1));
        System.out.println(solve(grid2));
        System.out.println(solve(grid3));
    }

    public static int solve(int[][] grid) {

        int len = grid.length;

        DisjointSet ds = new DisjointSet(len * len);

        int[] xDir = {1, -1, 0, 0};
        int[] yDir = {0, 0, 1, -1};

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (grid[r][c] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        int delRow = r + xDir[dir];
                        int delCol = c + yDir[dir];
                        if (isValid(len, delRow, delCol) && grid[delRow][delCol] == 1) {
                            int u = r * len + c;
                            int v = delRow * len + delCol;
                            ds.unionBySize(u, v);
                        }
                    }
                }
            }
        }

        int maxSize = 0;
        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> parentSet = new HashSet<>();
                    for (int dir = 0; dir < 4; dir++) {
                        int delRow = r + xDir[dir];
                        int delCol = c + yDir[dir];
                        if (isValid(len, delRow, delCol) && grid[delRow][delCol] == 1) {
                            int node = delRow * len + delCol;
                            int parent = ds.findParent(node);
                            parentSet.add(parent);
                        }
                    }
                    int size = 1;
                    for (int p : parentSet) {
                        size += ds.size.get(p);
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        maxSize = Math.max(maxSize, ds.getMaxSize());
        return maxSize;
    }

    public static boolean isValid(int len, int r, int c) {
        return r < len && c < len && r >= 0 && c >= 0;
    }
}
