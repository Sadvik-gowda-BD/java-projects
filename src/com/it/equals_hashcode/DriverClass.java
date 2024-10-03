package com.it.equals_hashcode;


/*
Default Behavior: The default implementation in the Object class provides distinct integers for different objects.

 */
public class DriverClass {


    public static void main(String[] args) {

        Student s1 = new Student(101, "test");
        Student s2 = new Student(101, "test2");
        Student s3 = new Student(101, "test");

        System.out.println("equals:" + s1.equals(s2));

        System.out.println("s1_hashcode: " + s1.hashCode());
        System.out.println("s1_hashcode: " + s1.hashCode());
        System.out.println("s2_hashcode: " + s2.hashCode());
        System.out.println("s3_hashcode: " + s3.hashCode());

    }

}
