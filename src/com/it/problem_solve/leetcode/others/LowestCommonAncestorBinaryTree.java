package com.it.problem_solve.leetcode.others;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

//236. Lowest Common Ancestor of a Binary Tree
public class LowestCommonAncestorBinaryTree {

    private static TreeNode solve2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        TreeNode left = solve2(root.left, p, q);
        TreeNode right = solve2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null || right != null) {
            if (root == p || root == q) {
                return root;
            }
        }

        if(root == p || root ==q){
            return root;
        }

        return left != null ? left : right;
    }

}
