package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {

    public static void main(String[] args) {

        solve();
        System.out.println();

    }

    public static void solve() {
        String st = "abc";
        HashMap<String, List<String>> hm = new HashMap<>();
        hm.put("a", List.of("b", "c"));
        hm.put("b", List.of("a", "c"));
        hm.put("c", List.of("a", "b"));

        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.add("a");
        set.add("a");

        while (!q.isEmpty()) {
            String node = q.poll();
            System.out.println(node);
            for (String n : hm.get(node)) {
                if (!set.contains(n)) {
                    q.add(n);
                    set.add(n);
                }
            }
        }
    }


}
