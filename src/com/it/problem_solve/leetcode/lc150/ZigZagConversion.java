package com.it.problem_solve.leetcode.lc150;

import com.it.problem_solve.util.PrintArray;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 4;

        String s2 = "PAYPALISHIRING";
        int r2 = 3;

        System.out.println(solve(s, numRows)); //PINALSIGYAHRPI
        System.out.println(solve(s2, r2)); //PAHNAPLSIIGYIR

    }

    //Simple code, easy to understand
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int idx = 0, d = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[idx].add(c);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static String solve(String s, int rows) {

        if (rows == 1) {
            return s;
        }
        int strLen = s.length();
        float val = (float) strLen / (2 * rows - 2);
        int box = (int) Math.ceil(val);
        int cols = box * (rows - 1);
        char[][] mat = new char[rows][cols];

        int ind = 0;
        for (int c = 0; c < cols; ) {
            if (ind >= s.length()) {
                break;
            }

            for (int r = 0; r < rows; r++) {
                if (ind >= s.length()) {
                    break;
                }
                mat[r][c] = s.charAt(ind);
                ind++;
            }

            c++;
            for (int d = rows - 2; d > 0; d--) {
                if (ind >= s.length()) {
                    break;
                }
                mat[d][c] = s.charAt(ind);
                ind++;
                c++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != 0) {
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }


}
