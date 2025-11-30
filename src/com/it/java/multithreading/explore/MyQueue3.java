package com.it.java.multithreading.explore;

import java.util.LinkedList;
import java.util.Queue;

/*
Here different threads can access MyQueue methods at same time.
Possible to access two method at a same time by different threads.
For example T1 can access add() and T2 can access remove() method at same time. Because both method uses different object
in synchronized block.
 */
public class MyQueue3<E> {

    private final Queue<E> queue = new LinkedList<>();
    private final Object obj1, obj2;

    public MyQueue3() {
        this.obj1 = new Object();
        this.obj2 = new Object();
    }

    public synchronized void add(E e) {
        synchronized (obj1) {
            queue.add(e);
        }

    }

    public synchronized E remove() {
        synchronized (obj2) {
            if (!queue.isEmpty()) {
                return queue.remove();
            }
            return null;
        }

    }
}
