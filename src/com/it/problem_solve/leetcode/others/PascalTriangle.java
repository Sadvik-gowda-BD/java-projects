package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle
 */
public class PascalTriangle {

    public static void main(String[] args) {

        System.out.println(solve1(5));
    }

    public static List<List<Integer>> solve1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                List<Integer> preRow = triangle.get(i - 1);
                int val = preRow.get(j - 1) + preRow.get(j);
                row.add(val);
            }
            if (i > 0) {
                row.add(1);
            }
            triangle.add(row);
        }

        return triangle;
    }

    private static List<List<Integer>> solve2(int n) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> preLs;
        List<Integer> initial = new ArrayList<>();
        initial.add(1);

        ls.add(initial);
        for (int i = 1; i <= n; i++) {
            List<Integer> ls1 = new ArrayList<>();
            preLs = ls.get(i - 1);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    ls1.add(1);
                } else {
                    ls1.add(preLs.get(j - 1) + preLs.get(j));
                }
            }
            ls.add(ls1);
        }
        ls.remove(1);
        return ls;
    }
}
