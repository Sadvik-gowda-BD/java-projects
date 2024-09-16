package com.it.java.multithreading.deadlock;

/*
Deadlock occurs in a situation where two or more threads are blocked forever, waiting for each other.
 */
public class DeadLock {

    public static void main(String[] args) {
        final String lock1 = "lock1";
        final String lock2 = "lock2";

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1 acquired lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Thread1 acquired lock2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread2 acquired lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Thread2 acquired lock1");
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}

/*
A solution for a problem is found at its roots. In deadlock it is the pattern of accessing the resources A and B, is the
main issue. To solve the issue we will have to simply re-order the statements (lock1, lock2) where the code is accessing shared resources.

How to Avoid Deadlock in Java?

1)Avoid Nested Locks: We must avoid giving locks to multiple threads, this is the main reason for a deadlock condition. It normally happens when you give locks to multiple threads.
2)Avoid Unnecessary Locks: The locks should be given to the important threads. Giving locks to the unnecessary threads that cause the deadlock condition.
3)Using Thread Join: A deadlock usually happens when one thread is waiting for the other to finish. In this case, we can use join with a maximum time that a thread will take.
 */
