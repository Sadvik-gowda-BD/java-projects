package com.it.others.garbagecollection;

public class SomeClass {

    @Override
    protected void finalize() {
        System.out.println("SomeClass finalize method is invoked");
    }
}
