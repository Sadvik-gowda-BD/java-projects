package com.it.encapsulation;

import java.io.Serializable;

public class EmployeeBean implements Serializable {

    private String name;
    private double salary;

    public EmployeeBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}
