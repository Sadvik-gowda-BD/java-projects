package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public static void main(String[] args) {

    }


    public static Node solve(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            for (Node neigNode : curNode.neighbors) {
                if (!map.containsKey(neigNode)) {
                    map.put(neigNode, new Node(neigNode.val));
                    q.add(neigNode);
                }
                map.get(curNode).neighbors.add(map.get(neigNode));
            }
        }
        return map.get(node);
    }


    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
