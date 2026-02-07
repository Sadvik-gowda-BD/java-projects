package com.it.problem_solve.leetcode.others;

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


    /*
    Just to explore, solved by recursion.
     */
    private static ListNode solveByRec(ListNode root) {
        if (root == null) return null;

        ListNode newRoot = rec(root, root.next);
        root.next = null;
        return newRoot;
    }

    private static ListNode rec(ListNode one, ListNode two) {
        if (two == null) return one;

        ListNode root = rec(one.next, two.next);
        two.next = one;
        return root;
    }

}
