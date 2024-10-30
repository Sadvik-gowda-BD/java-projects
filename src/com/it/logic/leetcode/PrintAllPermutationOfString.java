package com.it.logic.leetcode;

public class PrintAllPermutationOfString {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("abc");

        solve(sb, 0);

        //ab
        //ab

    }

    private static void solve(StringBuilder sb, int ind) {

        if (ind == sb.length()-1) {
            System.out.println(sb);
            return;
        }

        for (int i =ind; i<sb.length(); i++){
            swap(sb, ind, i);
            solve(sb, ind+1);
            swap(sb, ind, i);

        }
    }

    static void swap(StringBuilder sb, int i, int j) {
        char iChar = sb.charAt(i);
        char jChar = sb.charAt(j);
        sb.setCharAt(i, jChar);
        sb.setCharAt(j, iChar);
    }
}
