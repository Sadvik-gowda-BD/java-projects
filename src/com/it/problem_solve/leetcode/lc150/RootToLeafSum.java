package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class RootToLeafSum {

    public static void main(String[] args) {

    }

    public static int solve(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = solve(root.left, sum);
        int right = solve(root.right, sum);

        return left + right;
    }


}
