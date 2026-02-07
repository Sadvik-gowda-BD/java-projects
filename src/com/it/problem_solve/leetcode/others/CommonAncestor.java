package com.it.problem_solve.leetcode.others;

import com.it.dsa.datastrucuture.binarytree.TreeNode;
import com.it.dsa.datastrucuture.trie.TrieNode;

//235. Lowest Common Ancestor of a Binary Search Tree
public class CommonAncestor {

    static boolean isVisP;
    static TreeNode ans;

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;

        TreeNode p = t3;
        TreeNode q = t5;


        ans = null;
        solve(t1, p, q);
        System.out.println(ans);
        System.out.println(solveByBs(t1, p, q));

    }

    //There is always val is unique and p and q must present
    public static TreeNode solveByBs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = null, right = null;
        if (p.val < root.val && q.val < root.val) {
            left = solveByBs(root.left, p, q);
        }

        if (p.val > root.val && q.val > root.val) {
            right = solveByBs(root.right, p, q);
        }

        if (left != null || right != null){
            return left != null ? left : right;
        }

        return root;
    }


    //It works id P or Q not exist
    public static TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {

        if (ans != null) return ans;
        if (root == null) {
            return null;
        }

        TreeNode leftNode = solve(root.left, p, q);
        if (leftNode != null && (root == p || root == q)) {
            ans = root;
            return root;
        }
        TreeNode rightNode = solve(root.right, p, q);
        if (rightNode != null && (root == p || root == q)) {
            ans = root;
            return root;
        }

        if (leftNode != null && rightNode != null && ans == null) {
            ans = root;
            return root;
        }

        if (root == p) {
            return p;
        } else if (root == q) {
            return q;
        } else {
            return leftNode != null ? leftNode : rightNode;

        }

    }


}
