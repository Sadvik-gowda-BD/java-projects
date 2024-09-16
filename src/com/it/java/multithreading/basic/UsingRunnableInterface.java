package com.it.java.multithreading.basic;

public class UsingRunnableInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("Started in a thread name: " + Thread.currentThread().getName()
                + " ID: " + Thread.currentThread().getId());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Completed in a thread name: " + Thread.currentThread().getName()
                + " ID: " + Thread.currentThread().getId());
    }
}
