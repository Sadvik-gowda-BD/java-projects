package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.binarytree.CustomBinaryTree;
import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {

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

        System.out.println("Before");
        CustomBinaryTree cb = new CustomBinaryTree();
        cb.preOrderTraversalRecursion(n1);

        StringBuilder sb = new StringBuilder();
        serialize(n1, sb);

        System.out.println("\nSerialized string");
        System.out.println(sb.toString());

        System.out.println("After deserialize");
        BinaryNode newRoot = deSerialize(sb);

        cb.preOrderTraversalRecursion(newRoot);


    }

    //By using pre order
    private static void serialize(BinaryNode root, StringBuilder st) {

        if (root == null) {
            st.append("NULL").append(",");
            return;
        }
        st.append(root.data).append(",");
        serialize(root.left, st);
        serialize(root.right, st);
    }

    private static BinaryNode deSerialize(StringBuilder st) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(st.toString().split(",")));
        return deSerialize(nodes);
    }

    private static BinaryNode deSerialize(Queue<String> queue) {

        if (queue.isEmpty()) {
            return null;
        }

        String value = queue.poll();
        if (value.equals("NULL")) {
            return null;
        }

        BinaryNode node = new BinaryNode(Integer.parseInt(value));

        node.left = deSerialize(queue);
        node.right = deSerialize(queue);
        return node;
    }
}
