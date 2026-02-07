package com.it.problem_solve.leetcode.others;

import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

import java.util.Arrays;
import java.util.PriorityQueue;

//23. Merge k Sorted Lists
public class MergeKSortedList {

    public static void main(String[] args) {

        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;


        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;

        ListNode[] ls = {l11, l21, l31};

        ListNode res = solve(ls);

        ListNode node = res;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve(ListNode[] arr) {

        if (arr.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for (ListNode node : arr) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode head = null;
        ListNode node;
        ListNode preNode = null;
        while (!pq.isEmpty()) {
            node = pq.poll();
            if (head == null) {
                preNode = node;
                head = node;
                add(node.next, pq);
                continue;
            }
            add(node.next, pq);
            preNode.next = node;
            preNode = node;
        }

        if (preNode != null) {
            preNode.next = null;
        }

        return head;
    }

    private static void add(ListNode node, PriorityQueue<ListNode> pq) {
        if (node != null) {
            pq.add(node);
        }
    }


}
