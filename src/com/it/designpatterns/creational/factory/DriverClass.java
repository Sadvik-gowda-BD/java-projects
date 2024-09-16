package com.it.designpatterns.creational.factory;

public class DriverClass {

    public static void main(String[] args) {

        OperatingSystemFactory factory = new OperatingSystemFactory();

        //Here we are not exposing object creation directly
        OperatingSystem windows = factory.getOperatingSystem("windows");
        System.out.println(windows.getParentCompany());

        OperatingSystem ios = factory.getOperatingSystem("ios");
        System.out.println(ios.getParentCompany());

    }
}
