package test;

import com.it.problem_solve.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Test1 {

    public static void main(String[] args) {

        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(2, 2, 1, 2, 2, 2));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(1, 2, 2, 2, 1, 2));


        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(Arrays.asList(l1, l2));

        return;

    }

    private static ListNode solveByRec(ListNode root) {
        if (root == null) return null;

        ListNode newRoot = rec(root, root.next);
        root.next = null;
        return newRoot;
    }

    private static ListNode rec(ListNode one, ListNode two) {
        if (two == null) return one;

        ListNode root = rec(one.next, two.next);
        two.next = one;
        return root;
    }

    private static ListNode solve2(ListNode root) {

        if (root == null) return null;

        ListNode curr = root;
        ListNode pre = null;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}

