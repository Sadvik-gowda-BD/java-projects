package com.it.dsa.datastrucuture.binarytree.traversal;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.Stack;

public class DfsPreInPostOrder {

    public void preOrderTraversal(BinaryNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + "--> ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(BinaryNode root) {

        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + "--> ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(BinaryNode root) {

        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + "--> ");
    }

    public void preOrderTraversalIterator(BinaryNode node) {
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryNode temp = stack.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
}
