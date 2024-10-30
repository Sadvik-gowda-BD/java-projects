package com.it.logic.others;

import java.util.Arrays;

public class MaximumBreak {
    static int maxBreak(int[] start, int[] finish, int k) {
        int n = start.length;
        int maxBreak = 0;

        // Calculate initial breaks
        int[] breaks = new int[n + 1];
        breaks[0] = start[0];
        for (int i = 1; i < n; i++) {
            breaks[i] = start[i] - finish[i - 1];
        }
        breaks[n] = 15 - finish[n - 1];

        // Initial maximum break without rearranging
        maxBreak = Arrays.stream(breaks).max().orElse(0);
        System.out.println("Initial breaks: " + Arrays.toString(breaks));
        System.out.println("Initial max break: " + maxBreak);

        // Check rearrangements by moving up to k speeches
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && j <= i + k; j++) {
                swap(start, finish, i, j);
                int currentMaxBreak = calculateMaxBreak(start, finish);
                maxBreak = Math.max(maxBreak, currentMaxBreak);
                System.out.println("After swapping " + i + " and " + j + ": " + currentMaxBreak);
                swap(start, finish, i, j); // revert swap
            }
        }

        return maxBreak;
    }

    static void swap(int[] start, int[] finish, int i, int j) {
        int tempStart = start[i];
        int tempFinish = finish[i];
        start[i] = start[j];
        finish[i] = finish[j];
        start[j] = tempStart;
        finish[j] = tempFinish;
    }

    static int calculateMaxBreak(int[] start, int[] finish) {
        int n = start.length;
        int[] breaks = new int[n + 1];
        breaks[0] = start[0];
        for (int i = 1; i < n; i++) {
            breaks[i] = start[i] - finish[i - 1];
        }
        breaks[n] = 15 - finish[n - 1];

        return Arrays.stream(breaks).max().orElse(0);
    }

    public static void main(String[] args) {
        int[] start = {4, 6, 7, 10};
        int[] finish = {5, 7, 8, 11};
        int k = 2;
        System.out.println("Maximum networking break time: " + maxBreak(start, finish, k));
    }
}
