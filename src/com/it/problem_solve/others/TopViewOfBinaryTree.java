package com.it.problem_solve.others;


import com.it.dsa.datastrucuture.binarytree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

//GFG code
public class TopViewOfBinaryTree {

    public static void main(String[] args) {

    }

    /*
    The idea is similar to Vertical Order Traversal. Like vertical Order Traversal,
    we need to put nodes of the same horizontal distance together. We just do a level order traversal (bfs) instead of
    dfs so that the topmost node at a horizontal distance is visited before any other node of the same horizontal
    distance below it.
     */
    //Using BFS - O(n * log n) Time and O(n) Space
    public static void solveByBFS(TreeNode root) {

        Map<Integer, TreeNode> distanceMap = new HashMap<>();

        /*
        Object[]
        0 index store TreeNode object
        1 index store horizontal distance
         */
        Queue<Object[]> q = new LinkedList<>();
        Object[] rootNodeWithDist = new Object[]{0, root};
        q.add(rootNodeWithDist);

        while (!q.isEmpty()) {

            Object[] obj = q.poll();
            TreeNode node = (TreeNode) obj[0];
            int dist = (int) obj[1];

            if (!distanceMap.containsKey(dist)) {
                distanceMap.put(dist, node);
            }

            if (node.left != null) {
                q.add(new Object[]{node.left, dist - 1});
            }

            if (node.right != null) {
                q.add(new Object[]{node.right, dist + 1});
            }
        }

        // Extract the nodes from the map in sorted order
        // of their horizontal distances
        for (Map.Entry<Integer, TreeNode> entry : distanceMap.entrySet()) {
            System.out.println(entry.getValue());
        }

    }


    public static void solveByDFS(TreeNode root) {

        /*
        on Object[]
        0 index - store level
        1 index store Tree node
         */
        Map<Integer, Object[]> distanceMap = new TreeMap<>();
        dfs(root, 0, 0, distanceMap);

        for (Map.Entry<Integer, Object[]> entry : distanceMap.entrySet()) {
            System.out.println(entry.getValue()[1]);
        }
    }

    private static void dfs(TreeNode node, int level, int horizontalDistance, Map<Integer, Object[]> distanceMap) {

        if (node == null) {
            return;
        }

        if (!distanceMap.containsKey(horizontalDistance)) {
            distanceMap.put(horizontalDistance, new Object[]{level, node});
        } else {
            int existingHztDistanceLevel = (int) distanceMap.get(horizontalDistance)[0];
            if (existingHztDistanceLevel > level) {
                distanceMap.put(horizontalDistance, new Object[]{level, node});
            }
        }

        dfs(node.left, level + 1, horizontalDistance - 1, distanceMap);
        dfs(node.right, level + 1, horizontalDistance + 1, distanceMap);

    }
}
