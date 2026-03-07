package com.it.problem_solve.leetcode.others;

import java.util.List;

public class ListNode {

    public ListNode next;
    public int val;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode insert(List<Integer> ls) {

        ListNode head = null;
        ListNode pre = null;
        for (Integer num : ls) {
            if (head == null) {
                head = new ListNode(num);
                pre = head;
            } else {
                ListNode node = new ListNode(num);
                pre.next = node;
                pre = node;
            }
        }
        return head;
    }

    public static void print(ListNode head) {

        System.out.print(head.val);
        ListNode currNode = head.next;
        while (currNode != null) {
            System.out.print("->" + currNode.val);
            currNode = currNode.next;
        }
    }
}
