package com.it.equals_hashcode;

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
        Student st = (Student) obj;
        return this.id == st.id;
    }
}
