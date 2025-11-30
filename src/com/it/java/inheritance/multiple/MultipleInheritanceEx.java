package com.it.java.inheritance.multiple;

interface Parent1{

    default void defaultMet(){
        System.out.println("Parent 1 default met");
    }

    void met1();
}

interface Parent2{
    default void defaultMet(){
        System.out.println("Parent 2 default met");
    }

    void met2();
}


public class MultipleInheritanceEx implements Parent1, Parent2{

    /*If we don't override this method, we get compile time error. Because this method is existed on both Parent class.
    So it get confuse which one to invoke.
    Java class does not support Multiple inheritance. Java Interface supports by type but not by implementation.
     */
    public void defaultMet(){
        System.out.println("Child default met");
    }

    @Override
    public void met2() {

    }

    @Override
    public void met1() {

    }

    public static void main(String[] args) {

        MultipleInheritanceEx m = new MultipleInheritanceEx();
        m.defaultMet();
    }
}


