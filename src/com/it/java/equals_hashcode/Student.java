package com.it.java.equals_hashcode;

import java.util.Objects;

public class Student {

    int id;
    String name;

    public Student() {

    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
    If two objects are equal according to equals(), they MUST have the same hashCode().
    It is used when object will be stored on hash based collection like HashMap, HashSet, HashTable etc.
    By default hashcode is object memory address
     */
    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        Student other = (Student) obj;
        return this.id == other.id &&
                Objects.equals(this.name, other.name);
    }
}
