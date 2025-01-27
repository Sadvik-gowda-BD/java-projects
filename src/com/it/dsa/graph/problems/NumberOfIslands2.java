package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;
import com.it.problem_solve.util.PrintArray;

import java.util.ArrayList;
import java.util.List;

/*
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the
water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after
each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands2 {

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] A = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};

        System.out.println(solve(n, m, A));
    }

    public static List<Integer> solve(int rows, int cols, int[][] operators) {

        int[][] grid = new int[rows][cols];
        boolean[][] vis = new boolean[rows][cols];

        DisjointSet ds = new DisjointSet(rows * cols);
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;

        for (int[] op : operators) {
            int r = op[0];
            int c = op[1];

            if (vis[r][c]) {
                ans.add(cnt);
                continue;
            }

            vis[r][c] = true;
            grid[r][c] = 1;
            cnt++;

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int delRow = r + dr[i];
                int delCol = c + dc[i];

                System.out.println("del row:" + delRow + " del col:" + delCol);
                if (isValid(rows, cols, delRow, delCol) && grid[delRow][delCol] == 1) {
                    //give node number to grid like 0, 1, 2,3,4 etc. formula(r, c) = (r * total_Col) + col
                    int node = (cols * r) + c;
                    int delNode = (cols * delRow) + delCol;

                    if (ds.findParent(node) != ds.findParent(delNode)) {
                        cnt--;
                        ds.unionBySize(node, delNode);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    private static boolean isValid(int rows, int cols, int r, int c) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }


}

