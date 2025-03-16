package com.it.dsa.datastrucuture.binarytree;

public class CustomBinaryTree {

    private TreeNode head;

    public void insert(int data) {

        if (head == null) {
            //head = new Node(null, null, data);
        }
    }

    private TreeNode insert(TreeNode node, int data) {
        if(node == null){
            return new TreeNode(data);
        }

        if (data < node.val) {
            insert(node.left, data);
        } else {
            insert(node.right, data);
        }
        return node;
    }


    /*root left right
        Node n1 = new Node(2);
        Node n1 = new Node(3);
        Node n1 = new Node(4);
     */
    public void preOrderTraversalRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraversalRecursion(node.left);
        preOrderTraversalRecursion(node.right);
    }



    /*
        The left subtree is traversed first
        Then the root node for that subtree is traversed
        Finally, the right subtree is traversed
     */
    public void inOrderTraversalRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversalRecursion(node.left);
        System.out.print(node.val + " ");
        inOrderTraversalRecursion(node.right);
    }

    public void inOrderTraversalIterator(TreeNode root) {

    }

    /*
    The left subtree is traversed first
    Then the right subtree is traversed
    Finally, the root node of the subtree is traversed
     */
    public void postOrderTraversalRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversalRecursion(node.left);
        postOrderTraversalRecursion(node.right);
        System.out.print(node.val + " ");
    }

    public void postOrderTraversalIterator(TreeNode root) {

    }


    public void levelOrderTraversal(TreeNode node) {

    }

}
