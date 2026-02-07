package com.it.problem_solve.leetcode.others;


//83. Remove Duplicates from Sorted List
public class RemoveDuplicateInSortedLknList {

    public static void main(String[] args) {

    }

    public static ListNode solve(ListNode head) {

        if (head == null) return head;

        ListNode currentNode = head.next;
        ListNode preNode = head;

        while (currentNode != null) {
            while (currentNode != null && preNode.val == currentNode.val) {
                currentNode = currentNode.next;
            }
            preNode.next = currentNode;
            preNode = currentNode;
        }

        return head;

    }
}
