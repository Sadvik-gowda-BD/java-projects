package com.it.dsa.datastrucuture.binarytree.traversal;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.Stack;


/*
    One Rule to Remember:
        Preorder → Use when you need root first.
        Inorder → Use when BST is involved.
        Postorder → Use when you need bottom-up computation.
 */
public class DfsPreInPostOrder {

    /*
    Preorder Traversal (Root → Left → Right)
    ✅ Best for:
        ✔ Tree cloning or reconstruction.
        ✔ Serializing & Deserializing a tree.
        ✔ Finding the root first before working on subtrees.
     */
    public void preOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + "--> ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /*
    Inorder Traversal (Left → Root → Right)
    ✅ Best for:
        ✔ Getting sorted order of a Binary Search Tree (BST).
        ✔ Checking if a tree is a valid BST.
        ✔ Converting a BST to a sorted array.
     */
    public void inOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + "--> ");
        inOrderTraversal(root.right);
    }

    /*
    Postorder Traversal (Left → Right → Root)
    ✅ Best for:
        ✔ Deleting nodes in a tree (process children before root).
        ✔ Evaluating expressions in an Expression Tree.
        ✔ Finding height/depth of a tree.

        Bottom-up approach needed
     */
    public void postOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + "--> ");
    }

    public void preOrderTraversalIterator(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.val + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // Current must be NULL at this point, pop the top of the stack
            curr = stack.pop();
            System.out.print(curr.val + " ");

            // Now, visit the right subtree
            curr = curr.right;
        }
    }
}
