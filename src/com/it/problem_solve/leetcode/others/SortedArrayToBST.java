package com.it.problem_solve.leetcode.others;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//108. Convert Sorted Array to Binary Search Tree
//GFG & Leetcode
public class SortedArrayToBST {


    public static void main(String[] args) {

        int[] nums = new int[]{-10, -3, 0, 5, 9};

        solveByDFS(nums, 0, nums.length - 1);
        solveByBSF(nums);

    }

    public static TreeNode solveByDFS(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = solveByDFS(nums, left, mid - 1);
        root.right = solveByDFS(nums, mid + 1, right);

        return root;
    }

    public static TreeNode solveByBSF(int[] nums) {

        int len = nums.length;
        if (len == 0) return null;

        int mid = (len - 1) / 2;

        Queue<BsfPair> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[mid]);
        q.add(new BsfPair(root, 0, len - 1));

        while (!q.isEmpty()) {

            BsfPair pair = q.poll();
            TreeNode curr = pair.node;
            int st = pair.start, ed = pair.end;
            int md = st + (ed - st) / 2;

            if (st < md) {
                int leftval = st + (md - 1 - st) / 2;
//                int leftval = (st + md - 1) / 2;
                TreeNode leftNode = new TreeNode(nums[leftval]);
                curr.left = leftNode;
                q.add(new BsfPair(leftNode, st, md - 1));
            }

            if (ed > md) {
                int rightVal = (md + 1) + (ed - (md + 1)) / 2;
//                int rightVal = (mid + 1 + ed) / 2;
                TreeNode rightNode = new TreeNode(nums[rightVal]);
                curr.right = rightNode;
                q.add(new BsfPair(rightNode, md + 1, ed));
            }
        }
        return root;
    }

    private static class BsfPair {
        public BsfPair(TreeNode node, int start, int end) {
            this.node = node;
            this.start = start;
            this.end = end;
        }

        TreeNode node;
        int start;
        int end;
    }
}
