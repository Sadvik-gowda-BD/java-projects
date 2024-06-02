package com.it.singleton;

public final class SingletonClass {

    private static SingletonClass instance;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (null == instance) {
            synchronized (SingletonClass.class) {
                if (null == instance) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
