package com.it.java.multithreading.project.producerconsumer;

public class ProducerConsumer {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();


        //Using runnable
        Producer produceRunnable = new Producer(myQueue);
        Thread producer = new Thread(produceRunnable);

        //Using thread class
        Consumer consumer = new Consumer(myQueue);

        producer.start();
        consumer.start();


        /*
        //By using lambda
        Runnable runnableAdd1 = () -> {
            for (int i = 0; i < 30; i++) {
                myQueue.add(i);
            }
        };

        Runnable runnableRemove1 = () -> {
            for (int i = 0; i < 30; i++) {
                myQueue.remove();
            }
        };

        Thread producerThread1 = new Thread(runnableAdd1);
        Thread consumerThread1 = new Thread(runnableRemove1);

        consumerThread1.start();
        producerThread1.start();

         */
    }
}
