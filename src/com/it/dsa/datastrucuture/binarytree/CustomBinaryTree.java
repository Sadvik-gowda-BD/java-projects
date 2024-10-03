package com.it.dsa.datastrucuture.binarytree;

import java.util.Stack;

public class CustomBinaryTree {

    private Node head;

    public void insert(int data) {

        if (head == null) {
            //head = new Node(null, null, data);
        }
    }

    private Node insert(Node node, int data) {
        if(node == null){
            return new Node(data);
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
    public void preOrderTraversalRecursion(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversalRecursion(node.left);
        preOrderTraversalRecursion(node.right);
    }

    public void preOrderTraversalIterator(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    /*
        The left subtree is traversed first
        Then the root node for that subtree is traversed
        Finally, the right subtree is traversed
     */
    public void inOrderTraversalRecursion(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversalRecursion(node.left);
        System.out.print(node.data + " ");
        inOrderTraversalRecursion(node.right);
    }

    public void inOrderTraversalIterator(Node root) {

    }

    /*
    The left subtree is traversed first
    Then the right subtree is traversed
    Finally, the root node of the subtree is traversed
     */
    public void postOrderTraversalRecursion(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversalRecursion(node.left);
        postOrderTraversalRecursion(node.right);
        System.out.print(node.data + " ");
    }

    public void postOrderTraversalIterator(Node root) {

    }


    public void levelOrderTraversal(Node node) {

    }

}
