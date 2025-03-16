package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;
import com.it.dsa.datastrucuture.binarytree.traversal.BfsLevelOrderTraversal;

import java.util.Arrays;
import java.util.HashMap;

public class BTreeFromPreAndInOrder {

    static int inOrderInd = 0;

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solve2(preorder, inorder);
        BfsLevelOrderTraversal.levelOrderTraversal(root);

        System.out.println();
        TreeNode root2 = solve(preorder, inorder);
        BfsLevelOrderTraversal.levelOrderTraversal(root2);


    }


    public static TreeNode solve(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inorderIndex = new HashMap<>();
        int len = inorder.length;

        for (int i = 0; i < len; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return buildTree(preorder, 0, inorder, 0, len - 1, inorderIndex);


    }

    public static TreeNode buildTree(int[] preorder, int preInd, int[] inorder, int inStartInd, int inEndInd,
                                     HashMap<Integer, Integer> inorderIndexMap) {

        if (inStartInd > inEndInd || preInd >= preorder.length) return null;

        int val = preorder[preInd];
        TreeNode root = new TreeNode(val);
        int inRoot = inorderIndexMap.get(val);
        // inOrderInd--;
        int numsLeft = inRoot - inStartInd; // or we can use instance variable inOrderInd
        root.left = buildTree(preorder, preInd + 1, inorder, inStartInd, inRoot - 1, inorderIndexMap);
        root.right = buildTree(preorder, preInd + numsLeft + 1, inorder, inRoot + 1, inEndInd, inorderIndexMap);
        return root;
    }


    //More time and space

    public static TreeNode solve2(int[] preorder, int[] inorder) {

        if (inorder.length == 0) return null;

        int val = preorder[inOrderInd];
        inOrderInd++;
        TreeNode root = new TreeNode(val);
        int inOrderIndex = getInOrderIndex(val, inorder);
        root.left = solve2(preorder, Arrays.copyOfRange(inorder, 0, inOrderIndex));
        root.right = solve2(preorder, Arrays.copyOfRange(inorder, inOrderIndex + 1, inorder.length));
        return root;
    }

    private static int getInOrderIndex(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) return i;
        }
        return -1;
    }

}
