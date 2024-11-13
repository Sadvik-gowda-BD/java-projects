package com.it.typesofclass.StaticNestedClass;

/*
A static nested class is a static class defined within another class.
It cannot access non-static members of the outer class directly.
 */
public class StaticNestedClass {

    public static void main(String[] args) {

        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
        staticNestedClass.display();

    }

}

class OuterClass {
    static int x = 10;

    public void outerMethod(){
        System.out.println("Outer method");
    }

    static class StaticNestedClass {
        void display() {
            System.out.println("x = " + x);
        }
    }
}
