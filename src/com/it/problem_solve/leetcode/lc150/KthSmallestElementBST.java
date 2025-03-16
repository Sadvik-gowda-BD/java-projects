package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class KthSmallestElementBST {

    static TreeNode node = null;
    static int count;

    public static void main(String[] args) {

        count = 3;

    }


    public static void solve(TreeNode root) {

        if (root == null || node != null) {
            return;
        }

        solve(root.left);
        if (count == 1) {
            node = root;
        }
        count--;
        solve(root.right);
    }

}
