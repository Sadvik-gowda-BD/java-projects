package com.it.dsa.datastrucuture.binarytree.traversal;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BfsLevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            System.out.print(node.val + "--> ");
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
