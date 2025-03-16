package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.binarytree.CustomBinaryTree;
import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {

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

        System.out.println("Before");
        CustomBinaryTree cb = new CustomBinaryTree();
        cb.preOrderTraversalRecursion(n1);

        StringBuilder sb = new StringBuilder();
        serialize(n1, sb);

        System.out.println("\nSerialized string");
        System.out.println(sb.toString());

        System.out.println("After deserialize");
        TreeNode newRoot = deSerialize(sb);

        cb.preOrderTraversalRecursion(newRoot);


    }

    //By using pre order
    private static void serialize(TreeNode root, StringBuilder st) {

        if (root == null) {
            st.append("NULL").append(",");
            return;
        }
        st.append(root.val).append(",");
        serialize(root.left, st);
        serialize(root.right, st);
    }

    private static TreeNode deSerialize(StringBuilder st) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(st.toString().split(",")));
        return deSerialize(nodes);
    }

    private static TreeNode deSerialize(Queue<String> queue) {

        if (queue.isEmpty()) {
            return null;
        }

        String value = queue.poll();
        if (value.equals("NULL")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));

        node.left = deSerialize(queue);
        node.right = deSerialize(queue);
        return node;
    }
}
