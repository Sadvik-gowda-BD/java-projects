package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class MaxPathSumBT {

    static int sum = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public static int solve(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        sum = Math.max(sum, left + right + root.val);
        return sum;
    }

}
