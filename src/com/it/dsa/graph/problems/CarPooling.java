package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
1094. Car Pooling

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

 */
public class CarPooling {

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;


        System.out.println(solve(trips, capacity));
    }

    public static boolean solve(int[][] trips, int capacity) {

        int currCapacity = capacity;

        Arrays.sort(trips, (a1, a2) -> a1[1] - a2[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);

        for (int[] trip : trips) {
            if (capacity < (trip[0])) {
                return false;
            }

            if (pq.isEmpty()) {
                pq.add(trip);
                currCapacity -= trip[0];
                continue;
            }

            boolean canRemove = true;
            while (canRemove && !pq.isEmpty()) {
                int[] lt = pq.peek();
                if (trip[1] >= lt[2]) {
                    pq.poll();
                    currCapacity += lt[0];
                }else {
                    canRemove = false;
                }
            }

            if (currCapacity < (trip[0])) {
                return false;
            } else {
                pq.add(trip);
                currCapacity -= trip[0];
            }
        }
        return true;
    }
}

