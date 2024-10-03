package com.it.java.multithreading.explore;

import java.util.LinkedList;
import java.util.Queue;

//TODO: complete the program
public class MyQueue4_Static {

    public static final Queue<Integer> queue = new LinkedList<>();

    public MyQueue4_Static() {
    }

    public static synchronized void add(Integer e) {
            queue.add(e);
    }

    public static Integer remove() {
        synchronized (MyQueue4_Static.class) {
            if (!queue.isEmpty()) {
                return queue.remove();
            }
            return null;
        }
    }
}
