package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.linkedlist.ListNode;

import java.util.Stack;

public class ReverseKLinkList {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        solveOptimize(l1, 2, 4);


        ListNode cn = l1;

        while (cn != null) {
            System.out.println(cn.val);
            cn = cn.next;
        }


    }

    // dummy->1->2->3->4->5
    public static ListNode solveOptimize(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode currNode = dummy.next;
        ListNode leftPre = dummy;

        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        ListNode pre = null;

        for (int i = 0; i < (right - left + 1); i++) {
            ListNode temp = currNode.next;
            currNode.next = pre;
            pre = currNode;
            currNode = temp;
        }

        leftPre.next.next = currNode;
        leftPre.next = pre;

        return dummy.next;
    }


    public ListNode solve(ListNode head, int left, int right) {
        ListNode currNode = head;
        ListNode leftPre = null;
        ListNode rightNext = null;
        int len = 0;

        while (currNode != null) {
            if (left - 2 == len) leftPre = currNode;
            if (right == len) rightNext = currNode;
            len++;
            currNode = currNode.next;
        }

        if (leftPre == null) {
            currNode = head;
        } else {
            currNode = leftPre.next;
        }

        Stack<ListNode> st = new Stack<>();
        while (currNode != rightNext) {
            st.push(currNode);
            currNode = currNode.next;
        }

        while (!st.isEmpty()) {
            ListNode node = st.pop();
            if (leftPre == null) {
                head = node;
            } else {
                leftPre.next = node;
            }
            leftPre = node;
        }
        leftPre.next = rightNext;

        return head;
    }


}
