package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;
import com.it.dsa.datastrucuture.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraverse {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> solve(BinaryNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        BinaryNode node;
        Queue<BinaryNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> ls = new ArrayList<>(size);
            while (size > 0) {
                node = q.poll();
                ls.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                size--;
            }
            res.add(ls);
        }
        return res;
    }


    public void levelOrder(BinaryNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        levelOrder(root.left, level + 1, result);
        levelOrder(root.right, level + 1, result);
    }
}
