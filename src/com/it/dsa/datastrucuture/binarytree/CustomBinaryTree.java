package com.it.dsa.datastrucuture.binarytree;

public class CustomBinaryTree {

    private BinaryNode head;

    public void insert(int data) {

        if (head == null) {
            //head = new Node(null, null, data);
        }
    }

    private BinaryNode insert(BinaryNode node, int data) {
        if(node == null){
            return new BinaryNode(data);
        }

        if (data < node.data) {
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
    public void preOrderTraversalRecursion(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversalRecursion(node.left);
        preOrderTraversalRecursion(node.right);
    }



    /*
        The left subtree is traversed first
        Then the root node for that subtree is traversed
        Finally, the right subtree is traversed
     */
    public void inOrderTraversalRecursion(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversalRecursion(node.left);
        System.out.print(node.data + " ");
        inOrderTraversalRecursion(node.right);
    }

    public void inOrderTraversalIterator(BinaryNode root) {

    }

    /*
    The left subtree is traversed first
    Then the right subtree is traversed
    Finally, the root node of the subtree is traversed
     */
    public void postOrderTraversalRecursion(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversalRecursion(node.left);
        postOrderTraversalRecursion(node.right);
        System.out.print(node.data + " ");
    }

    public void postOrderTraversalIterator(BinaryNode root) {

    }


    public void levelOrderTraversal(BinaryNode node) {

    }

}
