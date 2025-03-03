package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {

    Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

    }

    public void insert(BinaryNode root) {
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

    Stack<BinaryNode> stack = new Stack<>();
    public void addToStack(BinaryNode root) {
        BinaryNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    public int next2() {
        BinaryNode node = stack.pop();
        if (node.right != null) {
            addToStack(node.right);
        }
        return node.val;
    }

    public boolean hasNext2() {
        return !stack.isEmpty();
    }


}
