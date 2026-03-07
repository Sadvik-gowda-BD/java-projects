package com.it.problem_solve.leetcode.others2;

import com.it.problem_solve.leetcode.others.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    private static boolean solveByStack(ListNode head) {

        Stack<ListNode> st = new Stack<>();

        ListNode node = head;

        while (node != null) {
            st.push(node);
            node = node.next;
        }


        node = head;
        while (!st.isEmpty()) {
            ListNode popNode = st.pop();
            if (node.val != popNode.val) {
                return false;
            }
            node = node.next;
        }

        return true;
    }

    private static boolean solveByReverse(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        ListNode right;
        ListNode left = pre;

        if (fast != null) { //odd element
            right = slow.next;
        } else {
            right = slow;
        }

        while (left != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


}
