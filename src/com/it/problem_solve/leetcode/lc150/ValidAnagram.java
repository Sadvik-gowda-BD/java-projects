package com.it.problem_solve.leetcode.lc150;

public class ValidAnagram {

    public static void main(String[] args) {

        System.out.println(solve("anagram", "nagaram"));
        System.out.println(solve("abc", "aba"));
    }

    private static boolean solve(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] countArr = new int[26];
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            countArr[ch1 - 'a']++;
            countArr[ch2 - 'a']--;
        }

        for (int val : countArr) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
