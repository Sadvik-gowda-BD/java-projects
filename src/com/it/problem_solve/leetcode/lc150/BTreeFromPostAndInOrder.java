package com.it.problem_solve.leetcode.lc150;

import com.it.dsa.datastrucuture.binarytree.TreeNode;
import com.it.dsa.datastrucuture.binarytree.traversal.BfsLevelOrderTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BTreeFromPostAndInOrder {

    int postOrderIndex = 0;

    public static void main(String[] args) {

        BTreeFromPostAndInOrder obj = new BTreeFromPostAndInOrder();


        //int[] preorder = {3, 9, 20, 15, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};

        obj.postOrderIndex = inorder.length - 1;

        TreeNode root = obj.solve2(postOrder, inorder);
        BfsLevelOrderTraversal.levelOrderTraversal(root);

        System.out.println();
        obj.postOrderIndex = inorder.length - 1;
        TreeNode root2 = obj.solve(postOrder, inorder);
        BfsLevelOrderTraversal.levelOrderTraversal(root2);
    }

    public TreeNode solve(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inIndexMap = new HashMap<>();
        int len = inorder.length;

        for (int i = 0; i < len; i++) {
            inIndexMap.put(inorder[i], i);
        }
        return solve(postorder, inIndexMap, 0, len - 1);
    }

    public TreeNode solve(int[] postOrder, Map<Integer, Integer> inorderIndMap, int inStartInd,
                          int inEndInd) {

        if (inStartInd > inEndInd || postOrderIndex < 0) return null;
        int val = postOrder[postOrderIndex];
        postOrderIndex--;
        TreeNode root = new TreeNode(val);
        int inRootIndex = inorderIndMap.get(val);
        root.right = solve(postOrder, inorderIndMap, inRootIndex + 1, inEndInd);
        root.left = solve(postOrder, inorderIndMap, inStartInd, inRootIndex - 1);
        return root;
    }


    public TreeNode solve2(int[] postOrder, int[] inOrder) {

        if (inOrder.length == 0) return null;
        int val = postOrder[postOrderIndex];
        postOrderIndex--;
        TreeNode root = new TreeNode(val);
        int inOrderIndex = getInOrderIndex(val, inOrder);
        root.right = solve2(postOrder, Arrays.copyOfRange(inOrder, inOrderIndex + 1, inOrder.length));
        root.left = solve2(postOrder, Arrays.copyOfRange(inOrder, 0, inOrderIndex));
        return root;
    }

    private static int getInOrderIndex(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) return i;
        }
        return -1;
    }


}
