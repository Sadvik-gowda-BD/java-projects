package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
207. Course Schedule

we can solve this by using topological sort
 */
public class CourseSchedule1 {

    public static void main(String[] args) {

        int[][] input = {{1, 0}};
        int ip1Course = 2;

        int[][] input2 = {{1, 0}, {1, 2}, {0, 1}};
        int ip2Course = 3;

        System.out.println(solve(ip2Course, input2));

    }

    public static boolean solve(int numCourses, int[][] prerequisites) {


        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preRequisit = prerequisites[i][1];
            adjList.get(preRequisit).add(course);
        }
        ArrayList<Integer> res = solveByBfs(numCourses, adjList);

        return res.size() == numCourses;
    }

    private static ArrayList<Integer> solveByBfs(int tNodes, List<List<Integer>> adjList) {

        int[] inDegree = getInDegree(adjList);

        System.out.println("IN degre: " + Arrays.toString(inDegree));

        //In queue store only the node which has in degree zero
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topologicalSort = new ArrayList<>();

        for (int n = 0; n < tNodes; n++) {
            if (inDegree[n] == 0) {
                q.add(n);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            topologicalSort.add(node);

            for (int adjNode : adjList.get(node)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        return topologicalSort;
    }

    private static int[] getInDegree(List<List<Integer>> adjList) {
        int tNodes = adjList.size();
        int[] nDegree = new int[tNodes];

        for (List<Integer> ls : adjList) {
            for (int n : ls) {
                nDegree[n]++;
            }
        }
        return nDegree;
    }

}
