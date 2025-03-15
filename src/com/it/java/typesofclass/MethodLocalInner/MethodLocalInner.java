package com.it.java.typesofclass.MethodLocalInner;

/*
A method local inner class is defined within a method of the outer class.
It can only be accessed within the method where it is defined.
 */
public class MethodLocalInner {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}

class OuterClass {

    void outerMethod() {

        class InnerClass {
            void innerMethod() {
                System.out.println("Inside innerMethod");
            }
        }

        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }
}
