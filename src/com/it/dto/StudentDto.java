package com.it.dto;

public class StudentDto implements Comparable<StudentDto>{

    public StudentDto(){

    }

    public StudentDto(int idNo, String name, int age) {
        this.idNo = idNo;
        this.name = name;
        this.age = age;
    }

    private int idNo;
    private String name;
    private int age;


    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(StudentDto o) {
        return idNo - o.getIdNo();
    }

    @Override
    public String toString() {
        return "Student{" +
                "idNo=" + idNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
