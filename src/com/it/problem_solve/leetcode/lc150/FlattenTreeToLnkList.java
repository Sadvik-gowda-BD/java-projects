package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlattenTreeToLnkList {

    private BinaryNode prev = null;

    public static void main(String[] args) {


    }

    //Optimized approach O(n)
    public void flatten(BinaryNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void solve(BinaryNode node) {
        List<BinaryNode> list = new ArrayList<>();
        solve(node, list);
        BinaryNode root = null;
        BinaryNode pre = null;

        for (int i = 0; i < list.size(); i++) {
            BinaryNode cn = list.get(i);
            cn.left = null;
            if (root == null) {
                pre = cn;
            } else {
                pre.right = cn;
            }
        }
    }


    public static void solve(BinaryNode node, List<BinaryNode> list) {
        if (node == null) {
            return;
        }

        list.add(node);
        solve(node.left, list);
        solve(node.right, list);
    }

}
