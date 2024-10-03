package com.it.java.multithreading.explore;

import java.util.Queue;

public class DriverClass {

    public static void main(String[] args) {

        Queue<Integer> queue = MyQueue4_Static.queue;

        MyQueue4_Static.add(1);
        MyQueue4_Static.add(2);
        MyQueue4_Static.add(3);

        System.out.println(queue);

        Runnable r1 = () -> {

        };
        Thread t1 = new Thread(r1);
    }


}
