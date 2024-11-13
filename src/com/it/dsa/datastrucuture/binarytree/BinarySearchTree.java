package com.it.dsa.datastrucuture.binarytree;

public class BinarySearchTree {

    public BinaryNode insertByRec(BinaryNode root, int val) {
        if (root == null) {
            return new BinaryNode(val);
        }
        if (root.data < val) {
            root.left = insertByRec(root.left, val);
        } else {
            root.right = insertByRec(root.right, val);
        }
        return root;
    }

    public BinaryNode insertByItr(int data, BinaryNode root) {

        if (root == null) {
            return new BinaryNode(data);
        }

        BinaryNode currNode = root;
        while (true) {
            if (data <= currNode.data) {
                if (currNode.left != null) {
                    currNode = currNode.left;
                } else {
                    currNode.left = new BinaryNode(data);
                    break;
                }
            } else {
                if (currNode.right != null) {
                    currNode = currNode.right;
                } else {
                    currNode.right = new BinaryNode(data);
                    break;
                }
            }
        }
        return root;
    }


    public BinaryNode deleteEle(int data, BinaryNode root) {

        if (root == null) {
            return null;
        }

        if (root.data == data) {
            return deleteHelper(root);
        }

        BinaryNode currNode = root;
        while (currNode != null) {
            if (data < currNode.data) {
                if (currNode.left != null && currNode.left.data == data) {
                    currNode.left = deleteHelper(currNode.left);
                } else {
                    currNode = currNode.left;
                }
            } else {
                if (currNode.right != null && currNode.right.data == data) {
                    currNode.right = deleteHelper(currNode.right);
                } else {
                    currNode = currNode.right;
                }
            }
        }
        return root;
    }

    private BinaryNode deleteHelper(BinaryNode node) {

        if (node.left == null) {
            return node.right;
        }

        if (node.right == null) {
            return node.left;
        }

        BinaryNode rightChild = getLastRight(node.left);
        rightChild.right = node.right;
        return node.left;
    }

    private BinaryNode getLastRight(BinaryNode node) {
        BinaryNode currNode = node;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        return currNode;
    }

}
