package com.it.java.multithreading.project.producerconsumer;

public class Producer implements Runnable{

    private final MyQueue myQueue;

    public Producer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            myQueue.add(i);
            //Add Thread.sleep(1000) to see difference.
        }
    }
}
