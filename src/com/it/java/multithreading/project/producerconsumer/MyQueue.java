package com.it.java.multithreading.project.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;


/*
The official Java concurrency rule is:
    Always use a while loop when waiting, never an if.
 */
public class MyQueue {

    private final Queue<Integer> queue;
    private final int maxSize;
    private final Object lock = new Object();


    MyQueue() {
        this.queue = new LinkedList<>();
        maxSize = 3;
    }

    public boolean add(int val) {
        //Use any object this, queue or any
        synchronized (lock) {
            while (queue.size() == maxSize) {
                try {
                    /*
                Why use while instead of if?

                 Multiple producer threads may be waiting when the queue is full.
                 When a consumer removes an element, it calls notifyAll(), which wakes up
                 ALL waiting producer threads.

                 If we used 'if', each awakened thread would assume the condition is now false
                 and immediately try to add an element — causing overflow or incorrect behavior.

                 Using 'while' ensures that after waking up, each thread re-checks the condition
                 queue.size() == maxSize. If the queue is still full, the thread waits again.
                     */
                    System.out.println("add method is waiting");
                    lock.wait(); // THREAD Releases lock and goes to WAITING state

                    // THREAD CONTINUES from this line AFTER wake-up or after re-acquiring the lock.

                    //InterruptedException will occur when this tread is in wait/sleep state and it another thread call interrupt() method.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            boolean add = queue.add(val);
            System.out.println("add method added value:" + val);
            lock.notifyAll();
            return add;
        }
    }

    public Integer remove() {
        synchronized (lock) {
            while (queue.isEmpty()) {
                try {
                    System.out.println("remove method is waiting");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Integer ele = queue.poll();
            System.out.println("remove method removed value:" + ele);
            lock.notifyAll();
            return ele;
        }
    }

}
