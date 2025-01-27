package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveStones {

    public static void main(String[] args) {

        int[][] s = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int[][] s2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        int[][] s3 = {{0, 0}};

        System.out.println(solve1(s));
        System.out.println(solve1(s2));
        System.out.println(solve1(s3));

        System.out.println("\nSolution 2");
        System.out.println(solve2(s));
        System.out.println(solve2(s2));
        System.out.println(solve2(s3));
    }

    public static int solve2(int[][] stones) {

        int len = stones.length;
        Map<Integer, Integer> xCordToInd = new HashMap<>();
        Map<Integer, Integer> yCordTOInd = new HashMap<>();
        DisjointSet ds = new DisjointSet(len);


        for (int i = 0; i < len; i++) {
            int[] cord = stones[i];

            int x = cord[0];
            int y = cord[1];

            int parentX = -1;
            int parentY = -1;

            if (xCordToInd.containsKey(x)) {
                int v = xCordToInd.get(x);
                int u = i;
                ds.unionBySize(u, v);
                parentX = ds.findParent(u);
            } else {
                xCordToInd.put(x, i);
            }

            if (yCordTOInd.containsKey(y)) {
                int v = yCordTOInd.get(y);
                int u = i;
                ds.unionBySize(u, v);
                parentY = ds.findParent(u);
            } else {
                yCordTOInd.put(y, i);
            }

            if (parentX != -1 && parentY != -1) {
                ds.unionBySize(parentX, parentY);
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (ds.findParent(i) == i) {
                ans = ans + ds.size.get(i) - 1;
            }
        }

        return ans;
    }

    public static int solve1(int[][] stones) {

        int rows = 0;
        int cols = 0;
        for (int[] cord : stones) {
            rows = Math.max(rows, cord[0]);
            cols = Math.max(cols, cord[1]);
        }
        rows++;
        cols++;

        boolean[][] grid = new boolean[rows][cols];
        DisjointSet ds = new DisjointSet(rows * cols);


        for (int[] cord : stones) {
            grid[cord[0]][cord[1]] = true;
        }

        int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c]) {
                    int currNode = (r * cols) + c;
                    List<Integer> neighNodes = findNeighNodes(grid, r, c);
                    for (int node : neighNodes) {
                        ds.unionBySize(currNode, node);
                    }
                }
            }
        }

        int totalNodes = rows * cols;
        for (int i = 0; i < totalNodes; i++) {
            int parent = ds.findParent(i);
            if (parent == i) {
                ans = ans + (ds.size.get(i) - 1);
            }
        }

        return ans;
    }

    private static List<Integer> findNeighNodes(boolean[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        List<Integer> nodes = new ArrayList<>();

        int tempR = r - 1;
        while (tempR >= 0) {
            if (grid[tempR][c]) {
                nodes.add(getNodeNum(cols, tempR, c));
                break;
            }
            tempR--;
        }
        tempR = r + 1;
        while (tempR < rows) {
            if (grid[tempR][c]) {
                nodes.add(getNodeNum(cols, tempR, c));
                break;
            }
            tempR++;
        }

        int tempC = c - 1;
        while (tempC >= 0) {
            if (grid[r][tempC]) {
                nodes.add(getNodeNum(cols, r, tempC));
                break;
            }
            tempC--;
        }

        tempC = c + 1;
        while (tempC < cols) {
            if (grid[r][tempC]) {
                nodes.add(getNodeNum(cols, r, tempC));
                break;
            }
            tempC++;
        }
        return nodes;
    }

    private static int getNodeNum(int cols, int r, int c) {
        return (r * cols) + c;
    }
}
