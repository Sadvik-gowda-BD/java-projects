package com.it.dsa.datastrucuture.linkedlist;

public class DriverClass {

    public static void main(String[] args) {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);

        System.out.println("Before remove");
        ll.print();
        ll.remove(30);
        System.out.println("After remove 30");
        ll.print();
        ll.remove(50);
        System.out.println("After remove 50");
        ll.print();
        System.out.println(ll.remove(12));
    }
}
