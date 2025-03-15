package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    public static void main(String[] args) {

    }

    public int[] solve(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] preq : prerequisites) {
            int course = preq[0];
            int preReqCourse = preq[1];
            adjList.get(preReqCourse).add(course);
        }

        int[] inDegree = new int[numCourses];

        for (List<Integer> neigh : adjList) {
            for (int toNode : neigh) {
                inDegree[toNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int currNode = q.poll();
            result.add(currNode);

            for (int neigNode : adjList.get(currNode)) {
                inDegree[neigNode]--;
                if (inDegree[neigNode] == 0) {
                    q.add(neigNode);
                }
            }
        }

        if(result.size() != numCourses){
            return new int[0];
        }

        int[] resArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
}
