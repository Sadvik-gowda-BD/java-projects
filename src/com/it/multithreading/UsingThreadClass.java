package com.it.multithreading;

import javax.sound.midi.Soundbank;

public class UsingThreadClass extends Thread {


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
