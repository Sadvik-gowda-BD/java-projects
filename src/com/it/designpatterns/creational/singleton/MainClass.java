package com.it.designpatterns.creational.singleton;

public class MainClass {

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            System.out.println(SingletonClass.getInstance());
        }

    }
}

