package com.it.problem_solve.leetcode.others2;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.HashMap;

//337. House Robber III
public class HouseRobber3 {

    public static void main(String[] args) {

    }


    public static int solveByBf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rob = root.val;

        if (root.left != null) {
            rob = rob + solveByBf(root.left.left) + solveByBf(root.left.right);
        }

        if (root.right != null) {
            rob = rob + solveByBf(root.right.left) + solveByBf(root.right.right);
        }

        int noRob = solveByBf(root.left) + solveByBf(root.right);

        return Math.max(rob, noRob);
    }

    public static int solveByMemo(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int rob = root.val;

        if (root.left != null) {
            rob = rob + solveByMemo(root.left.left, memo) + solveByMemo(root.left.right, memo);
        }

        if (root.right != null) {
            rob = rob + solveByMemo(root.right.left, memo) + solveByMemo(root.right.right, memo);
        }

        int noRob = solveByMemo(root.left, memo) + solveByMemo(root.right, memo);


        int res = Math.max(rob, noRob);
        memo.put(root, res);
        return res;
    }


    private static int solve2(TreeNode root) {

        int[] res = solve22(root);
        return Math.max(res[0], res[1]);
    }

    //POST order traversal
    /*
    In many binary tree DP problems we don’t convert to classical tabulation like array DP.
    Instead we use post-order traversal, which acts like bottom-up DP.
     */
    private static int[] solve22(TreeNode root) {

        if (root == null) {
            return new int[2]; // {rob, not-rob}
        }

        int[] left = solve22(root.left);
        int[] right = solve22(root.right);

        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }

}
