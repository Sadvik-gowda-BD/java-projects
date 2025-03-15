package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadderMinStep {

    public static void main(String[] args) {

        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};

        int ans = solve(board);
        System.out.println(ans);
    }

    public static int solve(int[][] board) {
        int len = board.length;
        int target = len * len;
        Set<Integer> vis = new HashSet<>();

        List<Node> list = new ArrayList<>();
        list.add(new Node());//dummy node

        int count = 1;
        boolean isLToR = true;
        for (int r = len - 1; r >= 0; r--) {
            if (isLToR) {
                for (int c = 0; c < len; c++) {
                    list.add(new Node(count, board[r][c], 0));
                    count++;
                }
            } else {
                for (int c = len - 1; c >= 0; c--) {
                    list.add(new Node(count, board[r][c], 0));
                    count++;
                }
            }
            isLToR = !isLToR;
        }
        //list.forEach(e -> System.out.println(e));

        Queue<Node> q = new LinkedList<>();
        Node initialNode = new Node(1, -1, 0);
        q.add(initialNode);
        vis.add(1);

        while (!q.isEmpty()) {
            Node currNode = q.poll();

            for (int i = 1; i <= 6; i++) {
                int newPos = currNode.pos + i;
                int newStep = currNode.step + 1;
                if (newPos == target) {
                    return newStep;
                }

                if (newPos > target) {
                    continue;
                }

                Node node = list.get(newPos);
                if (node.val == target) return newStep;
                Node newNode;
                if (node.val != -1) {
                    newNode = new Node(node.val, node.val, newStep);
                } else {
                    newNode = new Node(newPos, node.val, newStep);
                }
                if (!vis.contains(newNode.pos)) {
                    q.add(newNode);
                    vis.add(newNode.pos);
                }
            }
        }
        return -1;
    }

    private static class Node {

        int pos;
        int val;
        int step;

        public Node() {
        }

        public Node(int pos, int val, int step) {
            this.pos = pos;
            this.val = val;
            this.step = step;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pos=" + pos +
                    ", val=" + val +
                    ", step=" + step +
                    '}';
        }
    }
}
