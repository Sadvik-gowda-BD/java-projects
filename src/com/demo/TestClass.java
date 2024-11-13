package com.demo;

import java.util.HashMap;
import java.util.Map;


public class TestClass extends Test2 {

    public static void main(String[] args) {

        Map<String , Integer> map = new HashMap<>();
        map.values();


    }

    public static void print(Number i){
        System.out.println("Number");
    }

    public static void print(String s){
        System.out.println("String");
    }

    public static void print(String s, Object ob){
        System.out.println("s to o");
    }

    public static void print(Object ob, String s){
        System.out.println("o to s");
    }

}
