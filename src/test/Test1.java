package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Test1 {


    public static void main(String[] args) {

        int n = 0;

    }


    public int[] dijkstra(int V, int[][] edges, int src) {

        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new Pair(v, wt));
            adjList.get(v).add(new Pair(u, wt));
        }

        int[] distArr = new int[V];
        Arrays.fill(distArr, Integer.MAX_VALUE);

        distArr[src] = 0;

        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.weight == o2.weight) {
                    return o1.node - o2.node;
                }
                return o1.weight - o2.weight;
            }
        };

//        Queue<Pair> queue = new PriorityQueue<>(comp);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));

        while (!queue.isEmpty()) {
            Pair currNode = queue.poll();
            List<Pair> neighNodes = adjList.get(currNode.node);

            for (Pair neighNode : neighNodes) {
                int newWeight = currNode.weight + neighNode.weight;
                int toNode = neighNode.node;
                if (newWeight < distArr[toNode]) {
                    distArr[toNode] = newWeight;
                    queue.add(new Pair(toNode, newWeight));
                }
            }
        }

        return distArr;
    }


}

class Pair {

    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}


