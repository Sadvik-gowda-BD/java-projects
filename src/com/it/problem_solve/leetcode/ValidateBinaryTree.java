package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class ValidateBinaryTree {

    public static void main(String[] args) {

        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n15 = new TreeNode(15);
        TreeNode n12 = new TreeNode(12);
        TreeNode n17 = new TreeNode(17);

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

    //Solution by using InOrder traverse
    private static Integer pre = null;
    public static boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = inOrder(root.left);
        if (pre != null && pre >= root.val) {
            return false;
        }
        pre = root.val;
        boolean right = inOrder(root.right);

        return right && left;
    }

    private static boolean solve(TreeNode root, int minVal, int maxVal) {

        if (root == null) {
            return true;
        }
        if (!(minVal < root.val && maxVal > root.val)) {
            return false;
        }

        System.out.println("root.val:" + root.val + " min:" + minVal + " max:" + maxVal);

        return solve(root.left, minVal, root.val) && solve(root.right, root.val, maxVal);

    }
}
