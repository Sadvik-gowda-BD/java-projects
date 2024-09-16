package com.it.logic.leetcode;

public class Isomorphic {

    public static void main(String[] args) {

        System.out.println(solve("baaa", "cttt"));
    }

    private static boolean solve(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();

        int[] mapS1 = new int[256];
        int[] mapS2 = new int[256];

        for (int i = 0; i < len; i++) {
            int ch1 = s1.charAt(i);
            int ch2 = s2.charAt(i);

            if(mapS1[ch1]!=0 && mapS1[ch1] != ch2 || mapS2[ch2]!=0 && mapS2[ch2]!= ch1){
                return false;
            }
            mapS1[ch1] = ch2;
            mapS2[ch2] = ch1;
        }

        return true;
    }
}
