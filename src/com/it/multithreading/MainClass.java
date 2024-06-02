package com.it.multithreading;

public class MainClass {

    public static void main(String[] args) {

        UsingThreadClass usingThreadClass1 = new UsingThreadClass();
        usingThreadClass1.start();
        // usingThreadClass1.start(); it will cause error IllegalThreadStateException
        //usingThreadClass1.run(); it not make any sense, the execution will happen in same thread

        for (int i = 0; i < 10; i++) {
            UsingThreadClass usingThreadClass = new UsingThreadClass();
            usingThreadClass.start();
        }
        System.out.println("COMPLETED execution on MainClass for thread class");

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new UsingRunnableInterface();
            Thread runnableThread = new Thread(runnable);
            runnableThread.start();
        }
        System.out.println("COMPLETED execution on MainClass for Runnable obj class");


    }
}
