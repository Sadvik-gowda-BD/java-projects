package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

//112. Path Sum
public class PathSum {

    public static void main(String[] args) {

    }

    public static boolean solve(TreeNode root, int currSum, int reqSum) {
        if (root == null) {
            return false;
        }

        currSum += root.val;
        if (root.left == null && root.right == null) {
            return currSum == reqSum;
        }
        boolean left = solve(root.left, currSum, reqSum);
        if(left) return true; // optmize
        boolean right = solve(root.right, currSum, reqSum);

        return left || right;

    }
}
