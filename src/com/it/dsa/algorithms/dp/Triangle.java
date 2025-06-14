package com.it.dsa.algorithms.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//120. Triangle
public class Triangle {

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {

        List<List<Integer>> tri = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));

        List<List<Integer>> tri2 = List.of(List.of(1));

        System.out.println(solve(tri));
        System.out.println(solveNew(tri));
        System.out.println(solveWithMemoization(tri));

    }

    public static int solveWithMemoization(List<List<Integer>> triangle) {

        int rows = triangle.size();
        int cols = triangle.get(rows - 1).size();

        int[][] dp = new int[rows][cols];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveMemo(triangle, dp, 0, 0);
    }

    public static int solveMemo(List<List<Integer>> triangle, int[][] dp, int i, int j) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = triangle.get(i).get(j) + Math.min(solveMemo(triangle, dp, i + 1, j), solveMemo(triangle, dp, i + 1,
                j + 1));
        return dp[i][j];
    }

    public static int solve(List<List<Integer>> triangle) {

        int rows = triangle.size();
        int lastRowSize = triangle.get(rows - 1).size();
        int[] ans = new int[lastRowSize];

        List<Integer> preData = new ArrayList<>();
        preData.add(triangle.get(0).get(0));

        for (int i = 1; i < rows; i++) {
            List<Integer> currRow = triangle.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                int currVal = currRow.get(j);
                if (j == 0) {
                    ans[j] = currVal + preData.get(0);
                    continue;
                }
                if (j == currRow.size() - 1) {
                    ans[j] = currVal + preData.get(j - 1);
                    continue;
                }
                ans[j] = currVal + Math.min(preData.get(j - 1), preData.get(j));
            }
            preData.clear();
            for (int val : ans) {
                preData.add(val);
            }
//            System.out.println("i="+i+" "+preData);
        }

        return preData.stream().min(Comparator.naturalOrder()).orElse(0);
    }

    public static int solveNew(List<List<Integer>> triangle) {

        List<List<Integer>> dp = new ArrayList<>();

        dp.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            List<Integer> dpRow = new ArrayList<>();
            List<Integer> preDpRow = dp.get(i - 1);

            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    dpRow.add(row.get(0) + preDpRow.get(0));
                } else if (j == row.size() - 1) {
                    dpRow.add(row.get(j) + preDpRow.get(j - 1));
                } else {
                    dpRow.add(row.get(j) + Math.min(preDpRow.get(j - 1), preDpRow.get(j)));
                }
            }
            dp.add(dpRow);
        }

        List<Integer> lastRow = dp.get(dp.size() - 1);

        return lastRow.stream().mapToInt(i -> i).min().orElse(0);
    }


}
