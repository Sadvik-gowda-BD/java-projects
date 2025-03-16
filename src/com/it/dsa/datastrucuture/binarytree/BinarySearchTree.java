package com.it.dsa.datastrucuture.binarytree;

public class BinarySearchTree {

    public TreeNode insertByRec(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.left = insertByRec(root.left, val);
        } else {
            root.right = insertByRec(root.right, val);
        }
        return root;
    }

    public TreeNode insertByItr(int data, TreeNode root) {

        if (root == null) {
            return new TreeNode(data);
        }

        TreeNode currNode = root;
        while (true) {
            if (data <= currNode.val) {
                if (currNode.left != null) {
                    currNode = currNode.left;
                } else {
                    currNode.left = new TreeNode(data);
                    break;
                }
            } else {
                if (currNode.right != null) {
                    currNode = currNode.right;
                } else {
                    currNode.right = new TreeNode(data);
                    break;
                }
            }
        }
        return root;
    }


    public TreeNode deleteEle(int data, TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.val == data) {
            return deleteHelper(root);
        }

        TreeNode currNode = root;
        while (currNode != null) {
            if (data < currNode.val) {
                if (currNode.left != null && currNode.left.val == data) {
                    currNode.left = deleteHelper(currNode.left);
                } else {
                    currNode = currNode.left;
                }
            } else {
                if (currNode.right != null && currNode.right.val == data) {
                    currNode.right = deleteHelper(currNode.right);
                } else {
                    currNode = currNode.right;
                }
            }
        }
        return root;
    }

    private TreeNode deleteHelper(TreeNode node) {

        if (node.left == null) {
            return node.right;
        }

        if (node.right == null) {
            return node.left;
        }

        TreeNode rightChild = getLastRight(node.left);
        rightChild.right = node.right;
        return node.left;
    }

    private TreeNode getLastRight(TreeNode node) {
        TreeNode currNode = node;
        while (currNode.right != null) {
            currNode = currNode.right;
        }
        return currNode;
    }

}
