package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {

    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

    }

    public void insert(TreeNode root) {
        if (root == null) return;

        insert(root.left);
        queue.add(root.val);
        insert(root.right);
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }


    // -------------------------------------------------------
    //              Approach 2

    Stack<TreeNode> stack = new Stack<>();
    public void addToStack(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public int next2() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            addToStack(node.right);
        }
        return node.val;
    }

    public boolean hasNext2() {
        return !stack.isEmpty();
    }


}
