package com.demo;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;
import com.it.dsa.datastrucuture.linkedlist.ListNode;
import com.it.dsa.datastrucuture.stack.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test1 {




    //1->2->3->4->5->6->7
    //3->2->1->4->7->6->5
    public static void main(String[] args) throws Exception {


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l4;
        l3.next = l4;
        l4.next = l5;

        ListNode<Integer> d = new ListNode(-10);
        d.next = l1;



        ListNode n = new ListNode(0);

        insert(n, d);

        ListNode cn = d.next;
        while (cn != null) {
            System.out.println(cn.val);
            cn = cn.next;
        }

    }

    public static void insert(ListNode<Integer> node, ListNode<Integer> dummy) {
        //System.out.println(3);
        ListNode<Integer> pre = dummy;
        ListNode<Integer> cur = pre.next;

        while (cur != null) {

            if (cur.val >= node.val) {
                ListNode temp = pre.next;
                pre.next = node;
                node.next = temp;
                return;
            }
            pre = cur;
            cur = cur.next;
        }
    }




}
