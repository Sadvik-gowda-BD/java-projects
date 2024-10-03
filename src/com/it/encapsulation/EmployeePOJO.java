package com.it.encapsulation;

public class EmployeePOJO {

    private String name;
    private double salary;

    public EmployeePOJO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
