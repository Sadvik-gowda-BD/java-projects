package com.it.dsa.datastrucuture.linkedlist;

public class CustomLinkedList<E> {

    private CustomListNode<E> head;
    private CustomListNode<E> tail;

    public void add(E data) {
        CustomListNode<E> node = new CustomListNode<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(E data) {
        boolean isRemoved = false;
        CustomListNode<E> currentNode = head;
        CustomListNode<E> previousNode = null;
        while (currentNode != null) {
            if (currentNode.val.equals(data)) {
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
        CustomListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val +" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public CustomListNode<E> getHead(){
        return head;
    }
}
