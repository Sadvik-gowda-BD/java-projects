package com.it.problem_solve.leetcode;


import java.util.List;
import java.util.PriorityQueue;

//148. Sort List
public class SortLinkList {

    public static void main(String[] args) {

        solveByPq(null);
        mergeSort(null);
    }

    private static ListNode solveByPq(ListNode head) {

        if (head == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode currNode = head;

        while (currNode != null) {
            pq.add(currNode);
            currNode = currNode.next;
        }

        ListNode newHead = pq.poll();
        currNode = newHead;

        while (!pq.isEmpty()) {
            currNode.next = pq.poll();
            currNode = currNode.next;
        }
        currNode.next = null;
        return newHead;
    }


    private static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode sp = head;
        ListNode fp = head.next; // TO get the first mid for even elements

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }

        ListNode rightSide = sp.next;
        ListNode leftSide = head;
        sp.next = null;

        ListNode leftSortedNode = mergeSort(leftSide);
        ListNode rightSortedNode = mergeSort(rightSide);
        return merge(leftSortedNode, rightSortedNode);
    }

    public static ListNode merge(ListNode left, ListNode right) {

        ListNode initialNode = new ListNode();
        ListNode currentNode = initialNode;

        while (left != null && right != null) {
            if (left.val < right.val) {
                currentNode.next = left;
                left = left.next;
            } else {
                currentNode.next = right;
                right = right.next;
            }
            currentNode = currentNode.next;
        }

        if (left != null) {
            currentNode.next = left;
        }

        if (right != null) {
            currentNode.next = right;
        }
        return initialNode.next;
    }
}
