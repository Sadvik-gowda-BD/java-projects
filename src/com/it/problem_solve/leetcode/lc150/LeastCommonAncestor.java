package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class LeastCommonAncestor {

    public boolean isP;
    public boolean isQ;
    public TreeNode res;

    public static void main(String[] args) {

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);

        b1.left = b2;
        b1.right = b3;
        b2.left = b4;


        LeastCommonAncestor l = new LeastCommonAncestor();
//        l.solve(b1, b2, b4);
//        System.out.println(l.res.val);

        TreeNode result = l.lowestCommonAncestor(b1, b4, b2);
        System.out.println(result.val);


    }


    //Simple solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            if (root != null) System.out.println("root: " + root.val);
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (res != null) {
            return res;
        }

        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);

        if (left != null && right != null && res == null) {
            res = root;
        }

        if (root == p) {
            if (isQ && res == null && (left != null || right != null)) {
                if (root.right == right || root.left == left) {
                    res = root;
                }
            }
            isP = true;
            return root;
        }

        if (root == q) {
            if (isP && res == null && (left != null || right != null)) {
                if (root.right == right || root.left == left) {
                    res = root;
                }
            }
            isQ = true;
            return root;
        }

        if (left != null || right != null) {
            return root;
        }

        return null;
    }
}
