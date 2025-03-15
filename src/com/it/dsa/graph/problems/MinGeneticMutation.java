package com.it.dsa.graph.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//433. Minimum Genetic Mutation
public class MinGeneticMutation {

    public static void main(String[] args) {
        String startGene = "AACCTTGG";
        String endGene = "AATTCCGG";
        String[] bankArr = {"AATTCCGG", "AACCTGGG", "AACCCCGG", "AACCTACC"};

        System.out.println(solve(startGene, endGene, bankArr));

    }

    /*
    A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
     */
    private static int solve(String startGene, String endGene, String[] bankArr) {

        Set<String> bank = new HashSet<>(Arrays.asList(bankArr));
        char[] chars = {'A', 'C', 'G', 'T'};

        Queue<Pair> q = new LinkedList<>();
        Pair initialPair = new Pair(startGene, 0);
        q.add(initialPair);

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            String currGene = pair.gene;

            if (endGene.equals(currGene)) {
                return pair.len;
            }
            bank.remove(currGene); // Act as a visited node check, we can also add ele to visSet and then add to queue if !visSet.contains (newStr).

            char[] charArr = currGene.toCharArray();
            for (int i = 0; i < currGene.length(); i++) {
                char oldChar = charArr[i];
                for (int j = 0; j < chars.length; j++) {
                    if (charArr[i] == chars[j]) continue;
                    charArr[i] = chars[j];
                    String newStr = new String(charArr);
                    if (bank.contains(newStr)) {
                        q.add(new Pair(newStr, pair.len + 1));
                    }
                }
                charArr[i] = oldChar;
            }
        }
        return -1;
    }

    private static class Pair {

        String gene;
        int len;

        public Pair(String gene, int len) {
            this.gene = gene;
            this.len = len;
        }
    }
}
