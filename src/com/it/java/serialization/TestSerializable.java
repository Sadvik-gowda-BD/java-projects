package com.it.java.serialization;

import java.io.Serializable;

public class TestSerializable implements Serializable {

    private static final long serialVersionUID = 1L;

    public TestSerializable() {
    }

    public TestSerializable(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    int id;
    String name;
    transient String pwd;

    @Override
    public String toString() {
        return "Test1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
