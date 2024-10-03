package com.it.typesofclass.NestedInnerClass;

/*
1. Nested Inner Class
A nested inner class is a non-static class defined within another class.
It can access all members of the outer class, including private ones.
 */
public class NestedInnerClass {

    public static void main(String[] args) {

        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.display();

    }

}

class OuterClass{
    private int x = 10;

    class InnerClass {
        public void display() {
            System.out.println("x = " + x);
        }
    }
}
