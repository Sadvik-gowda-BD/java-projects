package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigZag {

    public static void main(String[] args) {

        System.out.println();
    }

    public static List<List<Integer>> solve(BinaryNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<BinaryNode> q = new LinkedList<>();
        boolean isRightToLeft = false;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println(size);
            LinkedList<Integer> ls = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                BinaryNode node = q.poll();
                if (isRightToLeft) {
                    ls.addFirst(node.val);
                } else {
                    ls.add(node.val);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }
            res.add(ls);
            isRightToLeft = !isRightToLeft;
        }
        return res;
    }
}
