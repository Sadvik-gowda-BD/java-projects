package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
1976. Number of Ways to Arrive at Destination
 */
public class NoWaysToDestination {


    public static void main(String[] args) {

        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};

        int n2 = 19;
        int[][] roads2 = {{1, 0, 7714}, {2, 1, 6248}, {2, 0, 13962}, {3, 1, 14818}, {3, 0, 22532}, {3, 2, 8570}, {3, 4, 9230}, {5, 4, 1241}, {5, 0, 33003}, {5, 2, 19041}, {5, 1, 25289}, {5, 3, 10471}, {1, 6, 33307}, {4, 6, 9259}, {3, 7, 20212}, {5, 7, 9741}, {6, 7, 1723}, {4, 7, 10982}, {7, 0, 42744}, {8, 4, 12772}, {8, 6, 3513}, {8, 0, 44534}, {8, 2, 30572}, {1, 8, 36820}, {8, 7, 1790}, {8, 3, 22002}, {9, 6, 13145}, {9, 5, 21163}, {8, 9, 9632}, {9, 4, 22404}, {9, 7, 11422}, {9, 1, 46452}, {9, 2, 40204}, {10, 8, 6014}, {10, 4, 18786}, {9, 11, 3472}, {11, 7, 14894}, {6, 11, 16617}, {4, 11, 25876}, {0, 11, 57638}, {11, 2, 43676}, {11, 5, 24635}, {2, 12, 50515}, {3, 12, 41945}, {12, 6, 23456}, {12, 8, 19943}, {10, 12, 13929}, {12, 1, 56763}, {12, 0, 64477}, {12, 11, 6839}, {5, 12, 31474}, {12, 4, 32715}, {12, 13, 1401}, {13, 10, 15330}, {8, 13, 21344}, {4, 13, 34116}, {13, 1, 58164}, {3, 13, 43346}, {9, 13, 11712}, {13, 0, 65878}, {13, 11, 8240}, {13, 7, 23134}, {11, 14, 10467}, {13, 14, 2227}, {14, 12, 3628}, {14, 1, 60391}, {14, 5, 35102}, {10, 14, 17557}, {14, 4, 36343}, {14, 0, 68105}, {14, 7, 25361}, {8, 14, 23571}, {6, 14, 27084}, {14, 3, 45573}, {14, 2, 54143}, {14, 9, 13939}, {15, 6, 35506}, {7, 15, 33783}, {15, 14, 8422}, {15, 5, 43524}, {16, 7, 4344}, {16, 1, 39374}, {0, 16, 47088}, {8, 16, 2554}, {0, 17, 77829}, {17, 4, 46067}, {8, 17, 33295}, {17, 6, 36808}, {17, 11, 20191}, {17, 10, 27281}, {17, 1, 70115}, {16, 17, 30741}, {14, 17, 9724}, {15, 17, 1302}, {7, 17, 35085}, {18, 3, 57742}, {18, 12, 15797}, {18, 7, 37530}, {18, 15, 3747}, {14, 18, 12169}, {18, 5, 47271}, {18, 9, 26108}};
        System.out.println(countPaths(n2, roads2));
    }


    public static int countPaths(int n, int[][] roads) {

        int src = 0;
        int destination = n - 1;
        int MOD = 1_000_000_007;

        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];

            adjList.get(u).add(new Pair(v, dist));
            adjList.get(v).add(new Pair(u, dist));
        }

        long[] distArr = new long[n];
        int[] ways = new int[n];

        Arrays.fill(distArr, Long.MAX_VALUE);
        Arrays.fill(ways, -1);

        distArr[src] = 0;
        ways[src] = 1;

        Comparator<QPair> c = new Comparator<QPair>() {
            @Override
            public int compare(QPair o1, QPair o2) {
                if (o1.weight != o2.weight) {
                    return o1.weight > o2.weight ? 1 : -1;
                }
                return o1.node - o2.node;
            }
        };
        PriorityQueue<QPair> q = new PriorityQueue<>(c);
        q.add(new QPair(0, 0));

        while (!q.isEmpty()) {
            QPair pair = q.poll();

            for (Pair neighNode : adjList.get(pair.node)) {

                long newDist = pair.weight + neighNode.wt;

                if (newDist < distArr[neighNode.to]) {
                    ways[neighNode.to] = ways[pair.node];
                    distArr[neighNode.to] = newDist;
                    q.add(new QPair(neighNode.to, newDist));
                } else if (newDist == distArr[neighNode.to]) {
                    ways[neighNode.to] = (ways[neighNode.to] + ways[pair.node]) % MOD;
                    //q.add(new QPair(neighNode.to, newDist));
                }
            }

        }

        System.out.println(Arrays.toString(distArr));
        System.out.println(Arrays.toString(ways));
        System.out.println(ways[n - 1]);
        return ways[n - 1];
    }

    private static class Pair {
        int to;
        int wt;

        public Pair(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    private static class QPair {
        int node;
        long weight;

        public QPair(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
