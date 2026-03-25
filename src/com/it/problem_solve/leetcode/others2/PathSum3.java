package com.it.problem_solve.leetcode.others2;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.HashMap;

//437. Path Sum III
public class PathSum3 {

    public static void main(String[] args) {

    }

    private static int solve(TreeNode root, int target) {

        return solve(root, 0, target, new HashMap<>());
    }

    private static int solve(TreeNode root, long currSum, int target, HashMap<Long, Integer> prefixSum) {

        if (root == null) return 0;

        currSum += root.val;

        int count = 0;
        if (currSum == target) count++;

        if (prefixSum.containsKey(currSum - target)) {
            count += prefixSum.get(currSum - target);
        }

        prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);

        count += solve(root.left, currSum, target, prefixSum);
        count += solve(root.right, currSum, target, prefixSum);

        prefixSum.put(currSum, prefixSum.get(currSum) - 1);
        return count;
    }

}
