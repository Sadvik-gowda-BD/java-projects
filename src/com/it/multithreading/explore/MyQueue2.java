package com.it.multithreading.explore;

import java.util.LinkedList;
import java.util.Queue;

/*
Here only one thread can MyQueue methods because synchronize lock by same object obj1.
Not possible access two method at a same time even by different threads.
For example T1 access add() and T2 access remove() method is not possible. If T1 block add() method then T2 has to
wait until T1 unlock/complete.
 */
public class MyQueue2<E> {

    private final Queue<E> queue = new LinkedList<>();
    private final Object obj1;

    public MyQueue2() {
        this.obj1 = new Object();
    }

    public void add(E e) {
        synchronized (obj1) {
            queue.add(e);
        }
    }

    public E remove() {
        synchronized (obj1) {
            if (!queue.isEmpty()) {
                return queue.remove();
            }
            return null;
        }

    }
}
