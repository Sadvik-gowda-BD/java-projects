package com.it.dsa.datastrucuture.linkedlist;

public class CustomListNode<E> {
    public E val;
    public CustomListNode<E> next;

    public CustomListNode() {

    }

    public CustomListNode(E val) {
        this.val = val;
        this.next = null;
    }
}
