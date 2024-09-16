package com.it.dsa.datastrucuture.binarytree;

public class BinarySearchTree {

    public Node insert(Node root, int val) {
        if (root == null) {
            root =  new Node(val);
            return root;
        }
        if (root.data < val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}
