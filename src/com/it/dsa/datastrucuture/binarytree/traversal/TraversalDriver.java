package com.it.dsa.datastrucuture.binarytree.traversal;

import com.it.dsa.datastrucuture.binarytree.CustomBinaryTree;
import com.it.dsa.datastrucuture.binarytree.BinaryNode;

public class TraversalDriver {

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

//        DfsPreInPostOrder dfs = new DfsPreInPostOrder();
//        System.out.println("\nPre order");
//        dfs.preOrderTraversal(n1);
//
//        System.out.println("\nIn order");
//        dfs.inOrderTraversal(n1);
//
//        System.out.println("\nPost order");
//        dfs.postOrderTraversal(n1);

        System.out.println("\nLevel order");
        BfsLevelOrderTraversal bfsLevelOrderTraversal = new BfsLevelOrderTraversal();
        bfsLevelOrderTraversal.levelOrderTraversal(n1);

    }
}
