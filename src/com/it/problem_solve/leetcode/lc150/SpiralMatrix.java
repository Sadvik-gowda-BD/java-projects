package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.List;

/*

54. Spiral Matrix
 */
public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] mat2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
        };

        solve(mat2);
    }

    //Simple code
    public List<Integer> solve2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++)
                result.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    result.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }

    private static List<Integer> solve(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int totalEle = rows * cols;

        List<Integer> ls = new ArrayList<>();

        int count = 0;

        int[] topLeft = {0, 0};
        int[] topRight = {0, cols - 1};
        int[] bottomRight = {rows - 1, cols - 1};
        int[] bottomLeft = {rows - 1, 0};

        while (count < totalEle) {

            //left to right
            for (int i = topLeft[1]; i <= topRight[1]; i++) {
                if (count == totalEle) {
                    break;
                }
                ls.add(mat[topLeft[0]][i]);
                count++;
            }

            //up to down
            for (int i = topRight[0] + 1; i <= bottomRight[0]; i++) {
                if (count == totalEle) {
                    break;
                }
                ls.add(mat[i][topRight[1]]);
                count++;
            }

            //bottom right to left
            for (int i = bottomRight[1] - 1; i >= bottomLeft[1]; i--) {
                if (count == totalEle) {
                    break;
                }
                ls.add(mat[bottomRight[0]][i]);
                count++;
            }

            //bottom left to up
            for (int i = bottomLeft[0] - 1; i > topLeft[0]; i--) {
                if (count == totalEle) {
                    break;
                }
                ls.add(mat[i][bottomLeft[1]]);
                count++;
            }

            topLeft[0]++;
            topLeft[1]++;

            topRight[0]++;
            topRight[1]--;

            bottomRight[0]--;
            bottomRight[1]--;

            bottomLeft[0]--;
            bottomLeft[1]++;
        }
        System.out.println(ls);

        return ls;
    }
}
