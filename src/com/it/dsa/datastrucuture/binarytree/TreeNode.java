package com.it.dsa.datastrucuture.binarytree;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
