package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class IsSameTree {

    public static void main(String[] args) {

    }

    public static boolean solve(TreeNode r1, TreeNode r2) {

        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }


        if (r1.val != r2.val) {
            return false;
        }

        boolean leftRes = solve(r1.left, r2.left);
        boolean rightRes = solve(r1.right, r2.right);

        return leftRes & rightRes;
    }
}
