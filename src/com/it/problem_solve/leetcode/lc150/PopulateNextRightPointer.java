package com.it.problem_solve.leetcode.lc150;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

    public static void main(String[] args) {

    }

    public static Node solve(Node root) {

        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size - 2; i++) {
                Node node = q.poll();
                if (i < size - 1) {
                    node.next = q.peek();
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return root;
    }


    public static Node rec(Node root) {
        if (root == null) {
            return root;
        }

        Node left = rec(root.left);
        Node right = rec(root.right);
        left.next = right;
        return root;
    }


    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
