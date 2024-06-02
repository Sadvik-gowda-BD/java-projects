package com.it.singleton;

public final class SingletonClass {

    //Volatile because instance value always needs to fetch from main memory not from any CPU core cache
    private static volatile SingletonClass instance;

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
