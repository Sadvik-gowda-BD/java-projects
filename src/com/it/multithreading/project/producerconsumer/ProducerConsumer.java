package com.it.multithreading.project.producerconsumer;

public class ProducerConsumer {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        Runnable runnableAdd1 = () -> {
            for (int i = 0; i < 10; i++) {
                myQueue.add(i);
            }
        };

        Runnable runnableRemove1 = () -> {
            for (int i = 0; i < 10; i++) {
                myQueue.remove();
            }
        };

        Thread producerThread1 = new Thread(runnableAdd1);
        Thread producerThread2 = new Thread(runnableAdd1);

        Thread consumerThread1 = new Thread(runnableRemove1);

        consumerThread1.start();
        producerThread1.start();
    }
}
