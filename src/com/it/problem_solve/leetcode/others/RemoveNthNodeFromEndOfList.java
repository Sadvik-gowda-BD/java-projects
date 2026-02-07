package com.it.problem_solve.leetcode.others;


import com.it.dsa.datastrucuture.linkedlist.CustomLinkedList;
import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);

        ll.print();

        solve(ll.getHead(), 4);

        ll.print();

    }

    private static CustomListNode solve(CustomListNode head, int n) {

        int count = 0;
        CustomListNode fp = head;
        CustomListNode sp = head;

        while (count < n) {
            fp = fp.next;
            count++;
        }

        CustomListNode preNode = null;
        while (fp != null) {
            preNode = sp;
            fp = fp.next;
            sp = sp.next;
        }

        if (sp == head) {
            return head.next;
        }

        preNode.next = sp.next;

        return head;
    }
}
