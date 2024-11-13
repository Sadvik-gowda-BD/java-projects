package com.it.dsa.datastrucuture.binarytree;

public class DriverClass {

    public static void main(String[] args) {
        CustomBinaryTree bt = new CustomBinaryTree();

        BinaryNode n1 = new BinaryNode(1);
        BinaryNode n2 = new BinaryNode(2);
        BinaryNode n3 = new BinaryNode(3);
        BinaryNode n4 = new BinaryNode(4);
        BinaryNode n5 = new BinaryNode(5);
        BinaryNode n6 = new BinaryNode(6);
        BinaryNode n7 = new BinaryNode(7);

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
