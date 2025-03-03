package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {

    }

    public static boolean solveByDfs(BinaryNode root) {

        if (root == null) {
            return true;
        }
        return solveByDfs(root.left, root.right);
    }

    public static boolean solveByDfs(BinaryNode left, BinaryNode right) {

        if (left == null || right == null) {
            return left == null && right == null;
        }

        if (left.val != right.val) {
            return false;
        }
        return solveByDfs(left.left, right.right) && solveByDfs(left.right, right.left);
    }

    public static boolean solveByBfs(BinaryNode root) {
        if (root == null) {
            return true;
        }

        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            BinaryNode n1 = q.poll();
            BinaryNode n2 = q.poll();

            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }

            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
}
