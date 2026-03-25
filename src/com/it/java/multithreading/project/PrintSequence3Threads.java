package com.it.java.multithreading.project;

public class PrintSequence3Threads {

    private int number = 1;
    private final int limit;

    public PrintSequence3Threads(int limit) {
        this.limit = limit;
    }

    public void printNumbers(int threadId) {
        while (true) {
            synchronized (this) {

                // Wait until it's this thread's turn
                while (number <= limit && (number - 1) % 3 != threadId) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                // Stop condition
                if (number > limit) {
                    notifyAll(); // wake others so they can exit
                    return;
                }

                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number++;

                notifyAll(); // wake up all waiting threads
            }
        }
    }

    public static void main(String[] args) {
        PrintSequence3Threads printer = new PrintSequence3Threads(15);

        Thread t1 = new Thread(() -> printer.printNumbers(0), "T1");
        Thread t2 = new Thread(() -> printer.printNumbers(1), "T2");
        Thread t3 = new Thread(() -> printer.printNumbers(2), "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}