package com.it.problem_solve.leetcode;


import com.it.dsa.datastrucuture.linkedlist.Node;

import java.util.HashSet;
import java.util.Set;

/*
141. Linked List Cycle
 */
public class LinkListCycle {

    public static void main(String[] args) {

    }


    //Fast slow pointer
    public boolean hasCycleByFastSlowPointer(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle2(Node head) {

        Set<Node> set = new HashSet<>();
        Node node = head;

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
