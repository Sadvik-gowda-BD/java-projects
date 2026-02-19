package test;

import java.util.Arrays;

public class Test2 {


    public static void main(String[] args) {

        char[][] mat = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        System.out.println(bruteForce(mat));
        System.out.println(solveByTabulation(mat));
    }

    private static int bruteForce(char[][] mat) {

        int res = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
//                int remainArea = Math.max(mat.length - i, mat[0].length - j);
//                remainArea *= remainArea;
//                if (remainArea <= res) {
//                    return res;
//                }
                int val = getMaxSq(mat, i, j);
                res = Math.max(res, val);
            }
        }

        return res;
    }

    private static int getMaxSq(char[][] mat, int i, int j) {
        int n = 0;

        int delRow = i;
        int delCol = j;
        while (delRow < mat.length && delCol < mat[0].length) {

            //vertical check
            for (int r = i; r <= delRow; r++) {
                if (mat[r][delCol] != '1') {
                    return n * n;
                }
            }

            //horizontal check
            for (int c = j; c <= delCol; c++) {
                if (mat[delRow][c] != '1') {
                    return n * n;
                }
            }
            n++;
            delRow++;
            delCol++;
        }

        return n * n;
    }

    private static int solveByTabulation(char[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] dp = new int[rows][cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(
                                dp[i - 1][j],
                                Math.min(dp[i][j - 1], dp[i - 1][j - 1])
                        );
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }


}


