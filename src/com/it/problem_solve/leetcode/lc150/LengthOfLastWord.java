package com.it.problem_solve.leetcode.lc150;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String str = "   fly me   to   the moon  ";

        System.out.println(solve(str));
    }

    private static int solve(String str) {

        String[] arr = str.split(" ");
        return arr[arr.length - 1].length();
    }
}
