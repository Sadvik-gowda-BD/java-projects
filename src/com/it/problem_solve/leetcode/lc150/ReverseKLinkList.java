package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

import java.util.Stack;

public class ReverseKLinkList {


    public static void main(String[] args) {

        CustomListNode l1 = new CustomListNode(1);
        CustomListNode l2 = new CustomListNode(2);
        CustomListNode l3 = new CustomListNode(3);
        CustomListNode l4 = new CustomListNode(4);
        CustomListNode l5 = new CustomListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        solveOptimize(l1, 2, 4);


        CustomListNode cn = l1;

        while (cn != null) {
            System.out.println(cn.val);
            cn = cn.next;
        }


    }

    // dummy->1->2->3->4->5
    public static CustomListNode solveOptimize(CustomListNode head, int left, int right) {

        CustomListNode dummy = new CustomListNode(0);
        dummy.next = head;

        CustomListNode currNode = dummy.next;
        CustomListNode leftPre = dummy;

        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        CustomListNode pre = null;

        for (int i = 0; i < (right - left + 1); i++) {
            CustomListNode temp = currNode.next;
            currNode.next = pre;
            pre = currNode;
            currNode = temp;
        }

        leftPre.next.next = currNode;
        leftPre.next = pre;

        return dummy.next;
    }


    public CustomListNode solve(CustomListNode head, int left, int right) {
        CustomListNode currNode = head;
        CustomListNode leftPre = null;
        CustomListNode rightNext = null;
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

        Stack<CustomListNode> st = new Stack<>();
        while (currNode != rightNext) {
            st.push(currNode);
            currNode = currNode.next;
        }

        while (!st.isEmpty()) {
            CustomListNode node = st.pop();
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
