package test;

import com.it.dsa.datastrucuture.binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Map;

public class Test1 {

    int x = 1;

    public static void main(String[] args) {


    }

    private TreeNode firstViolation;
    private TreeNode secondViolation;
    private TreeNode pre;

    public void solve(TreeNode root) {

        inOrder(root);
        if (firstViolation != null && secondViolation != null) {
            int temp = firstViolation.val;
            firstViolation.val = secondViolation.val;
            secondViolation.val = temp;
        }

    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (pre != null && pre.val > root.val) {
            if (firstViolation == null) {
                firstViolation = pre; //This could be large element should go right
            }
            secondViolation = root; //This could be small element should go left
        }

        pre = root;
        inOrder(root.right);
    }


    private static TreeNode findFaultNode(TreeNode root, int minVal, int maxVal) {
        if (root == null) return null;

        TreeNode leftNode, rightNode;

        if (root.val > maxVal || root.val < minVal) {
            return root;
        } else {
            leftNode = findFaultNode(root.left, minVal, root.val);
        }

        if (root.val > maxVal || root.val < minVal) {
            return root;
        } else {
            rightNode = findFaultNode(root.right, root.val, maxVal);
        }

        return leftNode != null ? leftNode : rightNode;
    }

}
