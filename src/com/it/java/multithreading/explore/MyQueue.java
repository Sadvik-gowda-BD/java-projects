package com.it.java.multithreading.explore;

import java.util.LinkedList;
import java.util.Queue;

/*
Here only one thread can access MyQueue methods.
Not possible to access two method at a same time even by different threads.
For example T1 access add() and T2 access remove() method is not possible. If T1 block access add() method then T2 has to
wait until T1 to unlock/complete.
Because internally it uses same object ("this" current instance) in synchronized method like below,
 */
public class MyQueue<E> {

    private final Queue<E> queue = new LinkedList<>();

    public synchronized void add(E e) {
        queue.add(e);
    }

    public synchronized E remove() {
        if (!queue.isEmpty()) {
            return queue.remove();
        }
        return null;
    }

    public void internalWorkOfSynchronizedMethod() {
        synchronized (this) {
            int test = 10;
            //code
        }
    }

    /*
    Here two different thread can access static Synchronise method and not-static synchronised method. Because
    non-static method uses synchronized (this) and static method uses synchronized (MyQueue.class).

     */
    public static void myStatic() { //or public synchronized static void myStatic()
        synchronized (MyQueue.class) {
            int test = 10;
            //code
        }
    }
}
