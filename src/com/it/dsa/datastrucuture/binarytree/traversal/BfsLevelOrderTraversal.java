package com.it.dsa.datastrucuture.binarytree.traversal;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BfsLevelOrderTraversal {

    public void levelOrderTraversal(BinaryNode root) {

        if (root == null) {
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            BinaryNode node = queue.poll();
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
