package com.it.problem_solve.leetcode.others;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

//654. Maximum Binary Tree
public class MaxBinaryTree {

    public static TreeNode solve(int[] nums) {
        int len = nums.length;
        return solve(nums, 0, len - 1);
    }

    //Use divide and conquer rule
    public static TreeNode solve(int[] nums, int l, int r) {

        if (r < l) return null;

        int max = -1;
        int ind = -1;

        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ind = i;
            }
        }

        TreeNode root = new TreeNode(max);

        root.left = solve(nums, l, ind - 1);
        root.right = solve(nums, ind + 1, r);

        return root;
    }

}
