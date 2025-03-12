package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {


    public static void main(String[] args) {

        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"),
                List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")
        );

        double[] res = calcEquation(equations, values, queries);

        System.out.println(Arrays.toString(res));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
                finalAns[i] = -1.0;
            } else {
                HashSet<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gr, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }

    public static HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> gr = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            gr.putIfAbsent(dividend, new HashMap<>());
            gr.putIfAbsent(divisor, new HashMap<>());

            gr.get(dividend).put(divisor, value);
            gr.get(divisor).put(dividend, 1.0 / value);
        }
        return gr;
    }

    public static void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, HashSet<String> vis, double[] ans, double temp) {
        if (vis.contains(node))
            return;

        vis.add(node);
        if (node.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, gr, vis, ans, temp * val);
        }
    }

    /*

     My default solution

    static HashMap<String, Integer> nodeMap = new HashMap<>();
    static int ind = 0;

    public static double[] solve(List<List<String>> equations, double[] values, List<List<String>> queries) {
        nodeMap.clear();
        ind = 0;
        Map<Double, List<List<Double>>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            double from = getNode(eq.get(0));
            double to = getNode(eq.get(1));

            if (map.containsKey(from)) {
                List<List<Double>> ls = map.get(from);
                ls.add(List.of(to, values[i]));
            } else {
                List<List<Double>> ls = new ArrayList<>();
                ls.add(List.of(to, values[i]));
                map.put(from, ls);
            }

            if (map.containsKey(to)) {
                List<List<Double>> ls = map.get(to);
                ls.add(List.of(from, 1 / values[i]));
            } else {
                List<List<Double>> ls = new ArrayList<>();
                ls.add(List.of(from, 1 / values[i]));
                map.put(to, ls);
            }
        }

        System.out.println(map);


        double[] ans = new double[queries.size()];
        int ind = -1;
        for (List<String> query : queries) {
            ind++;
            double from = getNode(query.get(0));
            double to = getNode(query.get(1));

            if (from == to && map.containsKey(from)) {
                ans[ind] = 1;
                continue;
            }

            Double val = bfs(map, from, to);

            if (val == null) {
                ans[ind] = -1;
            } else {
                ans[ind] = val;
            }
        }
        return ans;
    }

    public static Double bfs(Map<Double, List<List<Double>>> map, double from, double to) {

        if (!map.containsKey(from)) {
            return null;
        }

        double val = 1;
        boolean hasReached = false;
        Set<Double> set = new HashSet<>();

        Queue<Pair> q = new LinkedList<>();
        Pair initial = new Pair();
        initial.node = from;
        initial.weight = 1;
        q.add(initial);
        set.add(from);

        while (!q.isEmpty()) {
            Pair n = q.poll();
            List<List<Double>> neighs = map.get(n.node);
            if (neighs == null) continue;

            for (List<Double> neigh : neighs) {
                double neithTo = neigh.get(0);
                if (neithTo == to) {
                    val = n.weight * neigh.get(1);
                    hasReached = true;
                    break;
                }

                if (!set.contains(neithTo)) {
                    Pair newPair = new Pair();
                    newPair.weight = n.weight * neigh.get(1);
                    newPair.node = neithTo;
                    q.add(newPair);
                    set.add(neithTo);
                }
            }
        }


        if (hasReached) {
            return val;
        } else {
            return null;
        }
    }

    private static double getNode(String st) {
        if (!nodeMap.containsKey(st)) {
            nodeMap.put(st, ind);
        }
        ind++;
        return nodeMap.get(st);
    }

    private static class Pair {
        public double node;
        public double weight = 1;
    }

     */

}
