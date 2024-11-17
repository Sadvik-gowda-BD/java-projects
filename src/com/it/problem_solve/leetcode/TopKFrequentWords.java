package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.


 */
public class TopKFrequentWords {

    public static void main(String[] args) {


        System.out.println("a".compareTo("b"));

        String[] words = {
                "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        };
        int k = 4;
        List<String> res = solve(words, k);

        System.out.println(res);

        System.out.println(solveByUsingHeap(words, 4));
    }

    private static List<String> solveByUsingHeap(String[] words, int k) {
        HashMap<String, Integer> h = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            h.put(words[i], h.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if ((h.get(b) - h.get(a)) == 0)
                return a.compareTo(b);
            else return h.get(b) - h.get(a);
        });

        for (String s : h.keySet()) {
            pq.add(s);
        }

        List<String> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(pq.remove());
            k--;
        }
        return ans;
    }


    private static List<String> solve(String[] words, int k) {

        HashMap<String, Integer> hm = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for (String st : words) {
            hm.put(st, hm.getOrDefault(st, 0) + 1);
        }

        while (k != 0 && !hm.isEmpty()) {
            String key = null;
            Integer freq = Integer.MIN_VALUE;
            for (Map.Entry<String, Integer> es : hm.entrySet()) {

                if (es.getValue() > freq || key == null) {
                    key = es.getKey();
                    freq = es.getValue();
                } else if (es.getValue().equals(freq)) {
                    if (es.getKey().compareTo(key) < 0) {
                        key = es.getKey();
                    }
                }
            }
            hm.remove(key);
            ls.add(key);
            k--;
        }
        return ls;
    }


}
