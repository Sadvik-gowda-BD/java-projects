package com.it.java.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCounter {

    public static void main(String[] args) {

    }

}

class SynchronizeCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int get() {
        return count;
    }
}

class LockCounter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int get() {
        return count;
    }
}

class AtomicIntCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }
}
