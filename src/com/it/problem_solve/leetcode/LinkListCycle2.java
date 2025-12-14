package com.it.problem_solve.leetcode;


import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

import java.util.HashSet;
import java.util.Set;

//142. Linked List Cycle II
public class LinkListCycle2 {

    public static void main(String[] args) {

    }

    public static ListNode solve(ListNode head) {

        Set<ListNode> set = new HashSet<>();

        ListNode currNode = head;

        while (currNode != null) {
            if (set.contains(currNode)) {
                return currNode;
            }
            set.add(currNode);
            currNode = currNode.next;
        }

        return null;
    }

    //Fast slow pointer. SC = O(n)
    public ListNode solve2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
