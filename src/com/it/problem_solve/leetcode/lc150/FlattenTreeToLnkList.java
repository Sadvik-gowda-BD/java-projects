package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenTreeToLnkList {

    private TreeNode prev = null;

    public static void main(String[] args) {


    }

    //Optimized approach O(n)
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void solve(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        solve(node, list);
        TreeNode root = null;
        TreeNode pre = null;

        for (int i = 0; i < list.size(); i++) {
            TreeNode cn = list.get(i);
            cn.left = null;
            if (root == null) {
                pre = cn;
            } else {
                pre.right = cn;
            }
        }
    }


    public static void solve(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }

        list.add(node);
        solve(node.left, list);
        solve(node.right, list);
    }

}
