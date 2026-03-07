package com.it.problem_solve.leetcode.lc150;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//149. Max Points on a Line
public class MaxPointOnLine {

    public static void main(String[] args) {

    }

    public static int solve(int[][] arr) {

        if (arr.length == 1) return 1;

        int max = 2;
        for (int i = 0; i < arr.length; i++) {

            Map<Double, Integer> tangentMap = new HashMap<>();
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                int[] p1 = arr[i];
                int[] p2 = arr[j];
                int x1 = p1[0], x2 = p2[0];
                int y1 = p1[1], y2 = p2[1];

                double tangent = Math.atan2((y2 - y1), (x2 - x1));

                Integer count = tangentMap.getOrDefault(tangent, 1);
                tangentMap.put(tangent, count + 1);
            }

            int currMax = Collections.max(tangentMap.values());
            max = Math.max(currMax, max);
        }

        return max;
    }


}
