package com.it.problem_solve.leetcode.lc150;

public class IsSubsequence {

    public static void main(String[] args) {

        System.out.println(solve("abc", "ahbgdc"));
        System.out.println(solve("axc", "ahbgdc"));

    }

    private static boolean solve(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0) {
            return true;
        }

        if (sLen > tLen) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }

        int sPointer = 0, tPointer = 0;

        while (tPointer < tLen) {

            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }

            if (sPointer == sLen) {
                return true;
            }
            tPointer++;
        }

        return false;
    }
}
