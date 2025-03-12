package com.it.problem_solve.leetcode.lc150;

import com.it.problem_solve.util.PrintArray;

import java.util.Arrays;

public class BurstBalloons {

    public static void main(String[] args) {

        int[][] arr = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] arr2 = {{-2147483646, -2147483645}, {2147483646, 2147483647}};

        System.out.println(solve(arr));
        System.out.println(solve(arr2));
    }

    public static int solve(int[][] points) {
        int ans = 0;
        int len = points.length;

        //sort based on end coordinate
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            }
            return -1;
        });

        if (len == 0) return 0;

        int preEnd = points[0][1];
        ans++;

        for (int i = 1; i < len; i++) {
            int[] curr = points[i];
            if (curr[0] <= preEnd) {
                continue;
            } else {
                preEnd = curr[1];
                ans++;

            }
        }
        return ans;
    }

}
