package com.it.dsa.graph.problems;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    //TODO: Better to create a copy of array and then alter
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }

        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void dfs(int[][] image, int i, int j, int newColor, int initialColor) {

        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != initialColor) {
            return;
        }

        image[i][j] = newColor;

        dfs(image, i - 1, j, newColor, initialColor);
        dfs(image, i + 1, j, newColor, initialColor);
        dfs(image, i, j - 1, newColor, initialColor);
        dfs(image, i, j + 1, newColor, initialColor);

    }

}

/*
Time complexity
Total nodes TotalNodes = n*m
O(TotalNodes * 4)
 */