package com.it.dsa.datastrucuture.binarytree.traversal;

import com.it.dsa.datastrucuture.binarytree.CustomBinaryTree;
import com.it.dsa.datastrucuture.binarytree.TreeNode;

public class TraversalDriver {

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
