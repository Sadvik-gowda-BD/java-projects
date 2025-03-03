package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

public class CountNodesInBT {

    public static void main(String[] args) {

    }

    public static int solve(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);

        return left + right +1;
    }

}
