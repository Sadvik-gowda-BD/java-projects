package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {

    public static void main(String[] args) {

    }

    public static List<Integer> solve(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (i == len - 1) {
                    list.add(node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return list;
    }

    //add right node first to the queue
    public static List<Integer> solve2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    list.add(node.val);
                }
                if (node.right != null) q.add(node.right);
                if (node.left != null) q.add(node.left);
            }
        }
        return list;
    }

    void dfs(TreeNode node, List<Integer> result, int currDepth) {
        if (node == null) return;
        if (currDepth >= result.size()) {
            result.add(node.val);
        }
        if (node.right != null) dfs(node.right, result, currDepth + 1);
        if (node.left != null) dfs(node.left, result, currDepth + 1);
    }
}
