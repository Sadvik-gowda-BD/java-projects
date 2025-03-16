package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    public static void solveByDFS(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        solveByDFS(root.left);
        solveByDFS(root.right);
    }

    public static void solveByBFS(TreeNode root) {

        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right != null) {
                q.add(node.right);
            }

            if (node.left != null) {
                q.add(node.left);
            }

        }
    }

}
