package com.it.others.garbagecollection;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started");

        SomeClass someClass = new SomeClass();

        someClass = null; //Making reference null, so above object will be ready for garbage collection.
        System.gc();
        Thread.sleep(1000); // Giving some time for garbage collector to clean the unreferenced object


        System.out.println("Application ended");
    }
}
