package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

public class ValidateBinaryTree {

    public static void main(String[] args) {

        BinaryNode n10 = new BinaryNode(10);
        BinaryNode n5 = new BinaryNode(5);
        BinaryNode n2 = new BinaryNode(2);
        BinaryNode n4 = new BinaryNode(4);
        BinaryNode n15 = new BinaryNode(15);
        BinaryNode n12 = new BinaryNode(12);
        BinaryNode n17 = new BinaryNode(17);

        n10.left = n5;
        n10.right = n15;
        n5.left = n2;
        n5.right = n4;
        n15.left = n12;
        n15.right = n17;

//        BfsLevelOrderTraversal bfsLevelOrderTraversal = new BfsLevelOrderTraversal();
//        bfsLevelOrderTraversal.levelOrderTraversal(n10);

        boolean result = solve(n10, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println(result);

    }

    private static boolean solve(BinaryNode root, int minVal, int maxVal) {

        if (root == null) {
            return true;
        }
        if (!(minVal < root.data && maxVal > root.data)) {
            return false;
        }

        System.out.println("root.val:" + root.data + " min:" + minVal + " max:" + maxVal);

        return solve(root.left, minVal, root.data) && solve(root.right, root.data, maxVal);

    }
}