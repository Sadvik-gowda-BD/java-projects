package com.it.java.typesofclass.AnonymousInnerClass;

/*
An anonymous inner class is a class without a name and is defined and instantiated in a single statement.
It is often used to provide a quick implementation of an interface or an abstract class.
 */
public class AnonymousInnerClass {

    public static void main(String[] args) {

        TestInterface testInterface = new TestInterface() {
            @Override
            public void print() {
                System.out.println("My message");
            }
        };

        testInterface.print();
    }
}

interface TestInterface{
    void print();
}
