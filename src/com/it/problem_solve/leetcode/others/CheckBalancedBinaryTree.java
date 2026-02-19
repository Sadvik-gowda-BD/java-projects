package com.it.problem_solve.leetcode.others;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class CheckBalancedBinaryTree {

    private static boolean isBalanceTree = true;

    public static void main(String[] args) {
//        isBalanceTree = true;
//        solve(null);
//        System.out.println(isBalanceTree);

        boolean ans = solve2(null) != -1;
    }

    public static int solve2(TreeNode head) {
        if (head == null) return 0;

        int left = solve2(head.left);
        if (left == -1) return -1;
        int right = solve2(head.right);
        if (right == -1) return -1;

        int diff = Math.abs(left - right);
        if (diff > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    public static int solve(TreeNode root) {

        if (root == null) return 0;

        int leftDep = solve(root.left);
        int rightDep = solve(root.right);

        if (Math.abs(leftDep - rightDep) > 1) {
            isBalanceTree = false;
        }
        return Math.max(leftDep, rightDep) + 1;
    }
}
