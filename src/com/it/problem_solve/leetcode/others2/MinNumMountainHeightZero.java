package com.it.problem_solve.leetcode.others2;


import java.util.PriorityQueue;
import java.util.Queue;

//3296. Minimum Number of Seconds to Make Mountain Height Zero
public class MinNumMountainHeightZero {
    public static void main(String[] args) {

        int h = 10;
        int[] arr = new int[]{3, 2, 2, 4};


//        System.out.println(solveByBruteFore(arr, h));
        System.out.println(solveByPriorityQueue(arr, h));
        System.out.println(solveByBinarySearch(arr, h));
    }

    private static long solveByBinarySearch(int[] times, int height) {
        long minTime = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for (int time : times) {
            minTime = Math.min(minTime, time);
            max = Math.max(max, time);
        }

        long maxTime = (((long) height * (height + 1)) / 2) * minTime;

        long res = 0;
        while (minTime <= maxTime) {

            long mid = minTime + ((maxTime - minTime) / 2);
            boolean can = canComplete(height, times, mid);
            if (can) {
                res = mid;
                maxTime = mid - 1;
            } else {
                minTime = mid + 1;
            }
        }

        return res;
    }

    private static boolean canComplete(int height, int[] times, long allocatedTime) {

        int tempHeight = height;
        for (int i = 0; i < times.length; i++) {
            int n = getN(1, height, times[i], allocatedTime);
            tempHeight -= n;
            if (tempHeight <= 0) return true;
        }

        return false;
    }

    private static int getN(int l, int r, int time, long allocatedTime) {

        int ans = 0;

        while (l <= r) {

            int mid = l + ((r - l) / 2);

            long val = (long) time * mid * (mid + 1) / 2;

            if (val <= allocatedTime) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static long solveByBruteFore(int[] times, int height) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = times.length;

        int[][] compTime = new int[len][2];
        for (int i = 0; i < len; i++) {
            compTime[i] = new int[]{1, times[i]};
            min = Math.min(min, times[i]);
            max = Math.max(max, times[i]);
        }

        long maxTime = (((long) height * (height + 1)) / 2) * min;

        for (long currTime = min; currTime <= maxTime; currTime++) {
            for (int i = 0; i < len; i++) {
                if (compTime[i][1] == currTime) {
                    height--;
                    compTime[i][0]++;
                    compTime[i][1] = compTime[i][1] + (compTime[i][0] * times[i]);
                }
                if (height == 0) return currTime;
            }

        }
        return -1;
    }

    private static long solveByPriorityQueue(int[] times, int height) {

        Queue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        long max = -1;

        for (int i = 0; i < times.length; i++) {
            pq.add(new long[]{times[i], times[i], 1});
        }

        while (!pq.isEmpty()) {
            long[] workerTime = pq.poll();
            height--;

            max = Math.max(max, workerTime[0]);
            if (height == 0) return max;
            workerTime[2]++;
            workerTime[0] = workerTime[0] + (workerTime[1] * workerTime[2]);

            pq.add(workerTime);
        }

        return -1;
    }


}
