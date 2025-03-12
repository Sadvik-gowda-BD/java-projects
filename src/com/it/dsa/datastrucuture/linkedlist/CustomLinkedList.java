package com.it.dsa.datastrucuture.linkedlist;

public class CustomLinkedList<E> {

    private ListNode<E> head;
    private ListNode<E> tail;

    public void add(E data) {
        ListNode<E> node = new ListNode<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(E data) {
        boolean isRemoved = false;
        ListNode<E> currentNode = head;
        ListNode<E> previousNode = null;
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
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val +" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public ListNode<E> getHead(){
        return head;
    }
}
