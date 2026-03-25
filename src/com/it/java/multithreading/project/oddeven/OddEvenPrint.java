package com.it.java.multithreading.project.oddeven;

public class OddEvenPrint {

    static int number = 1;
    static final int LIMIT = 100;

    // Shared lock object
    static final Object lock = new Object();

    public static void main(String[] args) {

        Runnable oddRun = () -> {
            while (number <= LIMIT) {
                synchronized (lock) {
                    while (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if (number <= LIMIT) {
                        System.out.println("Odd: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        };

        Runnable evenRun = () -> {
            while (number <= LIMIT) {
                synchronized (lock) {
                    while (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if (number <= LIMIT) {
                        System.out.println("Even: " + number);
                        number++;
                        lock.notifyAll();
                    }
                }
            }
        };

        Thread t1 = new Thread(oddRun);
        Thread t2 = new Thread(evenRun);

        t1.start();
        t2.start();
    }

}
