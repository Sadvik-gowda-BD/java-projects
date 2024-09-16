package com.it.designpatterns.creational.builder;

public class Customer {
    public Customer(Builder customerBuilder) {
        this.idNo = customerBuilder.idNo;
        this.name = customerBuilder.name;
        this.age = customerBuilder.age;
    }

    private int idNo;
    private String name;
    private int age;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idNo=" + idNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        private int idNo;
        private String name;
        private int age;

        public Builder idNo(int idNo) {
            this.idNo = idNo;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }


    }
}
