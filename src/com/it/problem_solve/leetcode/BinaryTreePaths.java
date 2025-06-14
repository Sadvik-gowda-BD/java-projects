package com.it.problem_solve.leetcode;

import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

//257. Binary Tree Paths
public class BinaryTreePaths {

    public static void main(String[] args) {

        List<String> res = new ArrayList<>();
        TreeNode root = null;
        solve(root, res, "");
    }

    public static void solve(TreeNode root, List<String> ans, String st) {

        if (root == null) {
            return;
        }

        if(st.isEmpty()){
            st = st.concat(String.valueOf(root.val));
        }else {
            st = st.concat("->").concat(String.valueOf(root.val));
        }


        if (root.left == null && root.right == null) {
            ans.add(st);
            return;
        }

        solve(root.left, ans, st);
        solve(root.right, ans, st);
    }
}
