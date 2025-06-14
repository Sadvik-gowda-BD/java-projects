package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.List;

//2942. Find Words Containing Character
public class FindIndexOfChar {

    public static void main(String[] args) {

    }

    public static List<Integer> solve(String[] words, char ch) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (containsChar(words[i], ch)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean containsChar(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
