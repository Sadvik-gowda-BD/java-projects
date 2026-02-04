package test;

import com.it.dsa.datastrucuture.binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test1 {

    int x = 1;

    public static void main(String[] args) {


        int n = 4;
        int[][] edges = new int[][]{{0, 1, 3}, {3, 1, 1}, {2, 3, 4}, {0, 2, 2}};

        System.out.println(minCost(n, edges));
    }

    //edges u v weight
    public static int minCost(int n, int[][] edges) {


        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] distArr = new int[n];
        Arrays.fill(distArr, Integer.MAX_VALUE);


        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, 2 * wt));
        }

        Pair sourceNode = new Pair(0, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);
        pq.add(sourceNode);
        distArr[0] = 0;

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();

            List<Pair> neighNodes = adjList.get(currPair.v);

            for (Pair neighNode : neighNodes) {
                int newDistance = currPair.weight + neighNode.weight;
                if (newDistance < distArr[neighNode.v]) {
                    distArr[neighNode.v] = newDistance;
                    pq.add(new Pair(neighNode.v, newDistance));
                }
            }
        }

        System.out.println(Arrays.toString(distArr));

        return distArr[n - 1] == Integer.MAX_VALUE ? -1 : distArr[n - 1];
    }

    static class Pair {

        int v;
        int weight;

        public Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }


}
