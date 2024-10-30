package com.demo;

public final class SingletonClass {

    private static volatile SingletonClass INSTANCE = null;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {

        if (null == INSTANCE) {
            synchronized (SingletonClass.class) {
                if (null == INSTANCE) {
                    INSTANCE = new SingletonClass();
                }
            }
        }

        return INSTANCE;
    }

}
