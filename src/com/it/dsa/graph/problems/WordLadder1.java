package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
127. Word Ladder
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of
words beginWord -> s1 -> s2 -> ... -> sk such that:

 */
public class WordLadder1 {

    public static void main(String[] args) {

        String start = "hit";
        String target = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solve(start, target, wordList));

    }


    public static int solve(String start, String target, String[] words) {

        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 1));


        while (!q.isEmpty()) {

            Pair currPair = q.poll();
            String currWord = currPair.word;
            char[] ca = currWord.toCharArray();
            wordSet.remove(currWord);

            if (currWord.equals(target)) {
                return currPair.len;
            }

            for (int i = 0; i < currWord.length(); i++) {
                char oldChar = ca[i];
                for (int j = 0; j < 26; j++) {
                    ca[i] = (char) ('a' + j);
                    String newStr = new String(ca);
                    if (wordSet.contains(newStr)) {
                        q.add(new Pair(newStr, currPair.len + 1));
                    }
                }
                ca[i] = oldChar;
            }

        }

        return 0;
    }

    private static class Pair {

        String word;
        int len;

        public Pair(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }
}
