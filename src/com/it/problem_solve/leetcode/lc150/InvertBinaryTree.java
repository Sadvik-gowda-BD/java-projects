package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {

    }

    public static void solveByDFS(BinaryNode root) {
        if (root == null) {
            return;
        }

        BinaryNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        solveByDFS(root.left);
        solveByDFS(root.right);
    }

    public static void solveByBFS(BinaryNode root) {

        if(root == null){
            return;
        }
        Queue<BinaryNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {

            BinaryNode node = q.poll();

            BinaryNode temp = node.left;
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
