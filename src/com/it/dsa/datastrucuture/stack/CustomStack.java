package com.it.dsa.datastrucuture.stack;

public class CustomStack<E> {

    private Node head;

    public void push(E data) {
        Node<E> node = new Node<>(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            head = head.next;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("Stack list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
