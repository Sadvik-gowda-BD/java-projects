package com.it.problem_solve.leetcode.others2;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

//1372. Longest ZigZag Path in a Binary Tree
public class LongestZigZagBinaryTree {

    static int pathLength = 0;

    public static void main(String[] args) {

        dfsSol1(null, true, 0);
        dfsSol2(null, 0, null);

    }

    private static void dfsSol1(TreeNode node, boolean goLeft, int steps) {
        if (node == null) {
            return;
        }
        pathLength = Math.max(pathLength, steps);
        if (goLeft) {
            dfsSol1(node.left, false, steps + 1);
            dfsSol1(node.right, true, 1);
        } else {
            dfsSol1(node.left, false, 1);
            dfsSol1(node.right, true, steps + 1);
        }
    }


    private static int dfsSol2(TreeNode root, int currLen, Boolean isFromLeft) {

        if (root == null) {
            return currLen;
        }

        int left = 0;
        int right = 0;
        if (isFromLeft == null) {

            left = dfsSol2(root.left, 0, true);
            right = dfsSol2(root.right, 0, false);

        } else if (isFromLeft) {
            right = dfsSol2(root.right, currLen + 1, false);
            left = dfsSol2(root.left, 0, true);
        } else {
            left = dfsSol2(root.left, currLen + 1, true);
            right = dfsSol2(root.right, 0, false);
        }

        return Math.max(currLen, Math.max(left, right));
    }


}
