package com.it.dsa.datastrucuture.linkedlist;

public class ListNode<E> {
    public E data;
    public ListNode<E> next;

    public ListNode(E data) {
        this.data = data;
        this.next = null;
    }
}
