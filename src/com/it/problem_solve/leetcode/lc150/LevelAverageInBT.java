package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverageInBT {

    public static void main(String[] args) {

    }

    public static List<Double> solve(TreeNode root) {
        List<Double> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(sum / size);
        }
        return list;
    }
}
