package com.it.logic.others;

import java.util.PriorityQueue;
import java.util.Set;

public class SortTheVowels {

    public static void main(String[] args) {

        String st = "elephant";
        System.out.println(solve(st));
    }

    static String solve(String st) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder(st);

        PriorityQueue<Character> pq = new PriorityQueue<>();

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (vowels.contains(ch)) {
                pq.add(ch);
            }
        }

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (vowels.contains(ch)) {
                char v = pq.poll();
                sb.setCharAt(i, v);
            }
        }
        return sb.toString();
    }
}
