package com.it.others.garbagecollection;

public class SomeClass {

    /*
    Finalize method is deprecated
    Final alternatives to finalize() in Java:

    try-with-resources → automatic cleanup
    AutoCloseable with close() → manual cleanup
    Cleaner (Java 9+) → safe background cleanup
     */
    @Override
    protected void finalize() {
        System.out.println("SomeClass finalize method is invoked");
    }
}
