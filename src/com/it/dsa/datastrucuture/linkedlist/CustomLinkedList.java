package com.it.dsa.datastrucuture.linkedlist;

public class CustomLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    public void add(E data) {
        Node<E> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(E data) {
        boolean isRemoved = false;
        Node<E> currentNode = head;
        Node<E> previousNode = null;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                if (previousNode != null) {
                    previousNode.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }
                isRemoved = true;
                break;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return isRemoved;
    }

    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data +" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
