package com.demo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        int[] arr = {3, 4, 65};
        int start = 7, end = 66175;

        int[] arr2 = {2, 5, 7};
        int start2 = 3, end2 = 30;
        System.out.println(solve(arr, start, end));
    }


    static int solve(int[] arr, long start, int end) {

        Queue<Pair> q = new LinkedList<>();

        Set<Long> set = new HashSet<>();

        for (int n : arr) {
            set.add((long) n);
            long newStart = (n * start) % 100000;
            q.add(new Pair(newStart, 1));

        }

        while (!q.isEmpty()) {

            Pair p = q.poll();
            start = p.val;
            int step = p.step;

            for (int n : arr) {
                long newStart = (n * start) % 100000;

                if (newStart == end) {
                    return step + 1;
                }

                if (set.contains(newStart)) {
                    continue;
                }
                set.add(newStart);
                q.add(new Pair(newStart, step + 1));
            }
        }

        return -1;
    }

    static class Pair {

        long val;
        int step;

        public Pair(long val, int step) {
            this.val = val;
            this.step = step;
        }
    }


}
