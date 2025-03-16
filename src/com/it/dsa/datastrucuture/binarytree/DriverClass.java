package com.it.dsa.datastrucuture.binarytree;

public class DriverClass {

    public static void main(String[] args) {
        CustomBinaryTree bt = new CustomBinaryTree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println("\n===================PreOrder=======================");
        System.out.println("Expected: 1 2 4 5 3 6 7");
        System.out.println("Pre order traversal by recursion");
        bt.preOrderTraversalRecursion(n1);

        System.out.println();
        System.out.println("Pre order traversal by iterator");
        //bt.preOrderTraversalIterator(n1);

        System.out.println("\n===================InOrder=======================");

        System.out.println("Expected: 4 2 5 1 6 3 7");
        System.out.println("in order traversal by recursion");
        bt.inOrderTraversalRecursion(n1);

        System.out.println();
        System.out.println("in order traversal by iterator");
        bt.inOrderTraversalIterator(n1);

        System.out.println("\n===================PostOrder=======================");
        System.out.println("Expected: 4 5 2 6 7 3 1");
        System.out.println("post order traversal by recursion");
        bt.postOrderTraversalRecursion(n1);

        System.out.println();
        System.out.println("post order traversal by iterator");
        bt.postOrderTraversalIterator(n1);


    }
}
