package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.linkedlist.ListNode;

public class ReverseLinkedList {


    public static void main(String[] args) {

    }

    public static ListNode solve(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;

        while (currNode != null) {

            ListNode tempNext = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = tempNext;
        }
        return preNode;
    }
}
