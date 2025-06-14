package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

public class ReverseLinkedList {


    public static void main(String[] args) {

    }

    public static CustomListNode solve(CustomListNode head) {
        CustomListNode preNode = null;
        CustomListNode currNode = head;

        while (currNode != null) {

            CustomListNode tempNext = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = tempNext;
        }
        return preNode;
    }
}
