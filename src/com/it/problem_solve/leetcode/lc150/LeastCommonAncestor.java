package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

public class LeastCommonAncestor {

    public boolean isP;
    public boolean isQ;
    public BinaryNode res;

    public static void main(String[] args) {

        BinaryNode b1 = new BinaryNode(1);
        BinaryNode b2 = new BinaryNode(2);
        BinaryNode b3 = new BinaryNode(3);
        BinaryNode b4 = new BinaryNode(4);

        b1.left = b2;
        b1.right = b3;
        b2.left = b4;


        LeastCommonAncestor l = new LeastCommonAncestor();
//        l.solve(b1, b2, b4);
//        System.out.println(l.res.val);

        BinaryNode result = l.lowestCommonAncestor(b1, b4, b2);
        System.out.println(result.val);


    }


    //Simple solution
    public BinaryNode lowestCommonAncestor(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (root == null || root == p || root == q) {
            if (root != null) System.out.println("root: " + root.val);
            return root;
        }

        BinaryNode left = lowestCommonAncestor(root.left, p, q);
        BinaryNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public BinaryNode solve(BinaryNode root, BinaryNode p, BinaryNode q) {
        if (root == null) {
            return null;
        }

        if (res != null) {
            return res;
        }

        BinaryNode left = solve(root.left, p, q);
        BinaryNode right = solve(root.right, p, q);

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
