package com.it.java.multithreading.project.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    private final Queue<Integer> queue;
    private final int maxSize;

    MyQueue() {
        this.queue = new LinkedList<>();
        maxSize = 3;
    }

    public boolean add(int val) {
        //Use any object this, queue or any
        synchronized (queue) {
            while (queue.size() == maxSize) {
                try {
                    /*
                    Here in some case more than 1 thread can be in wait state like adder1, adder2 etc.
                    so use while(queue.size() == maxSize) instead of if (queue.size() == maxSize).
                    For ex when add1 thread in wait state adder2 thread can access this synchronized block.
                     */
                    System.out.println("add method is waiting");
                    queue.wait();

                    //InterruptedException will occur when this tread is in wait/sleep state and it another thread call interrupt() method.
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            boolean add = queue.add(val);
            System.out.println("add method added value:" + val);
            queue.notifyAll();
            return add;
        }
    }

    public Integer remove() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    System.out.println("remove method is waiting");
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Integer ele = queue.poll();
            System.out.println("remove method removed value:" + ele);
            queue.notifyAll();
            return ele;
        }
    }

}
