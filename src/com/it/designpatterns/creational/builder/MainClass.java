package com.it.designpatterns.creational.builder;

public class MainClass {

    public static void main(String[] args) {
        Customer c = new Customer.Builder().idNo(101)
                .name("Virat")
                .age(27)
                .build();
        System.out.println(c);

        Customer c2 = Customer.builder().idNo(102)
                .name("Nikki")
                .age(24)
                .build();
        System.out.println(c2);
    }
}
