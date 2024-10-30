package com.it.designpatterns.creational.singleton;

public final class SingletonClass {

    //Volatile because instance value always needs to fetch from main memory not from any CPU core cache
    private static volatile SingletonClass instance;

    //Reflection can break
    private SingletonClass() {

        //To make reflection safe
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already created!");
        }
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

/*

Other ways to break

-> Clone
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
}

->Serializable


 */

