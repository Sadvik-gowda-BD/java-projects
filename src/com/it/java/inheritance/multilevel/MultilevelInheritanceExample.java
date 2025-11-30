package com.it.java.inheritance.multilevel;

// Parent class (Level 1)
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Child class of Animal (Level 2)
class Mammal extends Animal {
    void walk() {
        System.out.println("This mammal walks on land.");
    }
}

// Child class of Mammal (Level 3)
class Dog extends Mammal {
    void bark() {
        System.out.println("The dog barks.");
    }
}

// Main class
public class MultilevelInheritanceExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();   // inherited from Animal
        dog.walk();  // inherited from Mammal
        dog.bark();  // defined in Dog
    }
}
