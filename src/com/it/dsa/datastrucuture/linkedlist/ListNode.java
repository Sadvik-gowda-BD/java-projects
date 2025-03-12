package com.it.dsa.datastrucuture.linkedlist;

public class ListNode<E> {
    public E val;
    public ListNode<E> next;

    public ListNode() {

    }

    public ListNode(E val) {
        this.val = val;
        this.next = null;
    }
}
