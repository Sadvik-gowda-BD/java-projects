package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test1 {

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(solve(mat,0,0,2));


    }


    private static int solve(int[][] mat, int r, int j1, int j2) {

        System.out.println("R:" + r + " j1:" + j1 + " j2:" + j2);

        if (j1 < 0 || j1 >= mat.length || j2 < 0 || j2 >= mat.length) return Integer.MIN_VALUE;

        if (r == mat.length - 1) {
            if (j1 == j2) {
                return mat[r][j1];
            } else {
                return mat[r][j1] + mat[r][j2];
            }
        }

        int max = 0;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int val = solve(mat, r + 1, j1 + d1, j2 + d2);
                max = Math.max(max, val);
            }
        }

        if (j1 == j2) {
            return mat[r][j1] + max;
        } else {
            return mat[r][j1] + mat[r][j2] + max;
        }

    }


}
