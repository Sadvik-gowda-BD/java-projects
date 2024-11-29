package com.it.problem_solve.leetcode;


import com.it.dsa.datastrucuture.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
141. Linked List Cycle
 */
public class LinkListCycle {

    public static void main(String[] args) {

    }


    //Fast slow pointer
    public boolean hasCycleByFastSlowPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode node = head;

        while(node != null){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
            node = node.next;
        }

        return false;

    }

}
