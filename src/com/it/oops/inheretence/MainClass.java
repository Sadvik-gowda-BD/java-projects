package com.it.oops.inheretence;

import com.demo.TestClass;

import java.security.PublicKey;

class Animal {
}

class Dog extends Animal{}

class Labrador extends Dog{}

public class MainClass{

    static void print(Animal animal){
        System.out.println("ANIMAL");
    }

    static void print(Dog dog){
        System.out.println("DOG");
    }

//    static void print(Labrador labrador){
//        System.out.println("LABRADOR");
//    }

    static void print(Object object){
        System.out.println("OBJECT");
    }

    public static void main(String[] args) {
        Labrador labrador = new Labrador();
        print(labrador); //DOG
        /*
        If print(Labrador labrador) exist then output is LABRADOR
        If print(Labrador labrador) not exist then output is DOG
        If print(Labrador labrador) and print(Dog dog) not exist then output is ANIMAL
         */

        TestClass testClass = new TestClass();
        print(testClass); //Object
    }
}
