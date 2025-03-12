package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.linkedlist.ListNode;

public class DeleteDuplicate {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode res = solve(l1);

        ListNode cn = res;
        while (cn != null) {
            System.out.println(cn.val);
            cn = cn.next;
        }

    }

    public static ListNode solve(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        ListNode d1 = dummy;
        ListNode cur = head;

        boolean isDup = false;
        while (cur != null) {
            if (cur.next == null) {
                if (!isDup) {
                    d1.next = cur;
                }else {
                    d1.next = null;
                }
                break;
            }
            if (cur.val == cur.next.val) {
                isDup = true;
            } else {
                if (!isDup) {
                    d1.next = cur;
                    d1 = d1.next;
                }
                isDup = false;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
