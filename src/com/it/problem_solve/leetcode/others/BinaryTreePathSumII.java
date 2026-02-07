package com.it.problem_solve.leetcode.others;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//113. Path Sum II
public class BinaryTreePathSumII {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> solve(TreeNode root, int target) {

        List<List<Integer>> res = new LinkedList<>();

        dfs(root, new LinkedList<>(), 0, target, res);
        return res;
    }

    public static void dfs(TreeNode root, LinkedList<Integer> path, int currSum, int target, List<List<Integer>> res) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == target) {
                res.add(new ArrayList<>(path));
            }
        }
        dfs(root.left, path, currSum, target, res);
        dfs(root.right, path, currSum, target, res);
        path.removeLast();
    }
}
