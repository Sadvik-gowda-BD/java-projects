package com.it.problem_solve.others;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(15);
        pq.add(7);
        pq.add(20);


        System.out.println(pq);

        System.out.println(pq.peek());
    }
}
