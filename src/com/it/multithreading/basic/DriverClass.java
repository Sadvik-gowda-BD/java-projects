package com.it.multithreading.basic;

public class DriverClass {

    public static void main(String[] args) {

        UsingThreadClass thread1 = new UsingThreadClass();
        thread1.setDaemon(true);
        thread1.start();
        thread1.setName("UsingThreadClass-1");
        System.out.println(thread1.getState());
        // thread1.start(); it will cause error IllegalThreadStateException
        //thread1.run(); it not make any sense, the execution will happen in same thread

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

        Runnable r1 = new UsingRunnableInterface();
        Thread t1 = new Thread(r1);
        t1.start();

        Runnable r2 = ()->{
            System.out.println("Inside run t2");
        };

        Thread t2 = new Thread(r2);
        t2.start();

        Thread t3 = new Thread(()->{
            System.out.println("Inside run t3");
        });
        t3.start();


    }
}
