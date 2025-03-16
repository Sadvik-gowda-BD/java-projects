package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

//530. Minimum Absolute Difference in BST
public class MinAbsDiff {

    static int min = Integer.MAX_VALUE;
    static Integer pre = null;

    public static void main(String[] args) {

    }

    public int solve(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        solve(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        solve(root.right);

        return min;
    }

}
