package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {

    public static void main(String[] args) {

    }

    public static int solveByBFS(TreeNode head) {

        if (null == head) {
            return 0;
        }

        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
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

    public int rec(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int left = rec(head.left);
        int right = rec(head.right);

        return Math.max(left, right) + 1;
    }
}
