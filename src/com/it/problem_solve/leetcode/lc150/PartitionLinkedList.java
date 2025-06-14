package com.it.problem_solve.leetcode.lc150;

public class PartitionLinkedList {

    public static void main(String[] args) {


    }

//    public ListNode solve(ListNode head, int x) {
//
//        ListNode smallListHead = new ListNode();
//        ListNode bigListHead = new ListNode();
//
//        ListNode smallPointer = smallListHead;
//        ListNode bigPointer = bigListHead;
//
//        while (head != null) {
//            if (head.val < x) {
//                smallPointer.next = head;
//                smallPointer = smallPointer.next;
//            } else {
//                bigPointer.next = head;
//                bigPointer = bigPointer.next;
//            }
//            head = head.next;
//        }
//
//        smallPointer.next = bigListHead.next;
//        bigPointer.next = null;
//        return smallListHead.next;
//    }
}
