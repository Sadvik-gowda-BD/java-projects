package com.it.problem_solve.leetcode.lc150;

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {


        System.out.println(solve("abba", "dog cat cat dog"));
    }

    private static boolean solve(String p, String s) {

        HashMap<Character, String> charToStr = new HashMap<>();
        HashMap<String, Character> strToChar = new HashMap<>();

        String[] strs = s.split(" ");
        if (p.length() != strs.length) {
            return false;
        }

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            String st = strs[i];

            if (!charToStr.containsKey(ch)) {
                charToStr.put(ch, st);
            }

            if (!strToChar.containsKey(st)) {
                strToChar.put(st, ch);
            }

            if (!charToStr.get(ch).equals(st) || strToChar.get(st) != ch) {
                return false;
            }

        }
        return true;
    }
}
