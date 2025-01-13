package com.it.dsa.graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
GFG
Given a sorted dictionary of an alien language having some words dict and k starting alphabets of a standard dictionary.
Find the order of characters in the alien language. If no valid ordering of letters is possible, then return an empty string.
 */
public class AlienDictionary {

    public static void main(String[] args) {

        String[] dict1 = {"baa", "abcd", "abca", "cab", "cad"};
        int k1 = 4;

        String result = solve(dict1, k1);

        System.out.println("Solution 2");
        System.out.println(result);

        System.out.println("\nSolution 2");
        // Negative test case
        String[] dict2 = {"dhhid", "dahi", "cedg", "fg", "gdah", "i", "gbdei", "hbgf", "e", "ddde"};
        int k2 = 9;
        System.out.println(solve(dict2, k2));
    }

    private static String solve(String[] dict, int k) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];

            int j = 0;

            while (j < word1.length() && j < word2.length()) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    graph.get(ch1 - 'a').add(ch2 - 'a');
                    break;
                }
                j++;
            }

        }

        List<Integer> topoSort = topoSort(graph);

        if (topoSort.size() != k) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i : topoSort) {
            sb.append((char) (i + 'a'));
        }

        return sb.toString();
    }

    private static List<Integer> topoSort(List<List<Integer>> graph) {

        int N = graph.size();
        int[] inDegree = new int[N];

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();

        for (List<Integer> ls : graph) {
            for (int neigNode : ls) {
                inDegree[neigNode]++;
            }
        }

        System.out.println("IN degree: "+ Arrays.toString(inDegree));
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int node = q.poll();
            topoSort.add(node);

            for (int n : graph.get(node)) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    q.add(n);
                }
            }

        }
        System.out.println("Topo sort: "+ topoSort);
        return topoSort;
    }


}
