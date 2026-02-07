package com.it.problem_solve.leetcode.others;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class CheckBalancedBinaryTree {

    private static boolean isBalanceTree = true;

    public static void main(String[] args) {
        isBalanceTree = true;
        solve(null);
        System.out.println(isBalanceTree);
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
