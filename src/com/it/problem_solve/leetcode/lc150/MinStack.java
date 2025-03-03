package com.it.problem_solve.leetcode.lc150;

public class MinStack {

    private Node head;
    private Node min;

    public MinStack() {

    }

    public void push(int val) {
        Node node = new Node(val);
        if (null == head) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

        if (min != null && min.val > val) {
            min = node;
        }
    }

    public void pop() {
        if (null != head) {
            if (min == head) {
                min = null;
            }
            head = head.next;
        }

    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        if (min == null) {
            Node cn = head;
            min = cn;
            while (null != cn) {
                if (cn.val < min.val) {
                    min = cn;
                }
                cn = cn.next;
            }
        }
        return min.val;
    }

}

class Node {

    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
