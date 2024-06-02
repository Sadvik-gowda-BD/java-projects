package com.it.others;

public class ExecutionFlow {

    //static block can be execute without creating object
    static {
        System.out.println("inside static block");
    }

    {
        System.out.println("inside instance block");
    }

    int i = getVal();

    static int j = getStaticVal();

    public ExecutionFlow(){
        System.out.println("inside constructor");
    }

    private int getVal(){
        System.out.println("initialization of instance variable");
        return 10;
    }

    private static int getStaticVal(){
        System.out.println("initialization of static variable");
        return 10;
    }

    public static void main(String[] args) {
        System.out.println("Inside main method");
        new ExecutionFlow();
    }

}
