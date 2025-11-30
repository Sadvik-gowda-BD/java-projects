package com.it.java.multithreading.project.producerconsumer;

public class Consumer extends Thread {

    private final MyQueue myQueue;

    public Consumer(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            myQueue.remove();
        }
    }
}
