package com.it.java.multithreading.project.readCheckUpdate;

import java.util.concurrent.locks.ReentrantLock;

public class ReadCheckUpdate {

    public static void main(String[] args) {
        SharedResource sr = new SharedResource(6);

        System.out.println(sr.get());
        System.out.println(sr.updateIfCondition(6));
    }

}


class SharedResource {

    private int value;
    private final ReentrantLock lock = new ReentrantLock();

    public SharedResource(int val) {
        this.value = val;
    }
//    public synchronized int get() {
//        return value;
//    }

    public synchronized int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }

    }

    // Atomic read-check-update
    public int updateIfCondition(int target) {
        lock.lock();
        try {
            if (value == target) {
                value++;
            }
            return value;
        } finally {
            lock.unlock();
        }
    }
}
