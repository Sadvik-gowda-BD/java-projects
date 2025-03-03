package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {

    public static void main(String[] args) {

    }

    public static int solveByBFS(BinaryNode head) {

        if (null == head) {
            return 0;
        }

        int count = 0;
        Queue<BinaryNode> q = new LinkedList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                BinaryNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }
        }
        return count;
    }

    public int rec(BinaryNode head) {
        if (head == null) {
            return 0;
        }

        int left = rec(head.left);
        int right = rec(head.right);

        return Math.max(left, right) + 1;
    }
}
