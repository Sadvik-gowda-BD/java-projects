package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

public class DeleteDuplicate {

    public static void main(String[] args) {

        CustomListNode l1 = new CustomListNode(1);
        CustomListNode l2 = new CustomListNode(2);
        CustomListNode l3 = new CustomListNode(3);
        CustomListNode l4 = new CustomListNode(4);
        CustomListNode l5 = new CustomListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        CustomListNode res = solve(l1);

        CustomListNode cn = res;
        while (cn != null) {
            System.out.println(cn.val);
            cn = cn.next;
        }

    }

    public static CustomListNode solve(CustomListNode head) {
        CustomListNode dummy = new CustomListNode(-1000);
        CustomListNode d1 = dummy;
        CustomListNode cur = head;

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
