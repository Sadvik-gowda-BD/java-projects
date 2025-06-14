package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.linkedlist.CustomListNode;

public class IntersectionOfTwoLinklist {

    public static void main(String[] args) {

    }

    private CustomListNode solve2(CustomListNode head1, CustomListNode head2) {

        CustomListNode h1 = head1;
        CustomListNode h2 = head2;

        while (h1 != h2) {

            if (h1 == null) {
                h1 = head2;
            } else {
                h1 = h1.next;
            }
            if (h2 == null) {
                h2 = head1;
            } else {
                h2 = h2.next;
            }

        }

        return h1;
    }

    private CustomListNode solve1(CustomListNode head1, CustomListNode head2) {

        int l1 = 0;
        int l2 = 0;

        CustomListNode h1 = head1;
        CustomListNode h2 = head2;

        while (h1 != null) {
            l1++;
            h1 = h1.next;
        }

        while (h2 != null) {
            l2++;
            h2 = h2.next;
        }

        while ((l1 > l2) || (l2 > l1)) {
            if (l1 > l2) {
                h1 = h1.next;
                l1--;

            } else {
                h2 = h2.next;
                l2--;
            }
        }

        h1 = head1;
        h2 = head2;

        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }


        return h1;
    }
}
