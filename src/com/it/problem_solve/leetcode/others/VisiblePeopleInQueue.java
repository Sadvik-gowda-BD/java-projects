package com.it.problem_solve.leetcode.others;


import java.util.Arrays;

/*
1944. Number of Visible People in a Queue

 */
public class VisiblePeopleInQueue {

    //TODO complete and fix bug
    public static void main(String[] args) {

        int[] heights = {10, 6, 8, 5, 11, 9};

        int[] res = solve(heights);

        System.out.println(Arrays.toString(res));

    }

    private static int[] solve(int[] heights) {


        int len = heights.length;
        int[] res = new int[len];


        for (int i = 0; i < len - 1; i++) {

            int max = 0;
            int count = 0;
            for (int j = i + 1; j < len; j++) {

                int minIJHeight = Math.min(heights[i], heights[j]);

                if (minIJHeight > max) {

                    if (max > heights[j]) {
                        max = heights[j];
                    }

                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }
}
