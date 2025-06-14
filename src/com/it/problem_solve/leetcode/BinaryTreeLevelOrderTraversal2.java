package com.it.problem_solve.leetcode;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//107. Binary Tree Level Order Traversal II
public class BinaryTreeLevelOrderTraversal2 {

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        System.out.println(solve(t1));
    }

    public static List<List<Integer>> solve(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                ls.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.addFirst(ls);
        }
        return res;
    }

    public static List<List<Integer>> solve2(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Deque<TreeNode> allNode = new LinkedList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                allNode.addFirst(node);
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
            if (!q.isEmpty()) {
                allNode.addFirst(null);
            }
        }

        while (!allNode.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            while (!allNode.isEmpty() && allNode.peekFirst() != null) {
                TreeNode node = allNode.pollFirst();
                ls.add(node.val);
            }
            res.add(ls);
            allNode.pollFirst();
        }

        return res;
    }
}
