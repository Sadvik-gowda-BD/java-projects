package com.it.problem_solve.leetcode;

/*
1888. Minimum Number of Flips to Make the Binary String Alternating
 */

public class MinFlip {

    public static void main(String[] args) {
        String s = "0001010111";

        System.out.println(solve(s));
    }

    private static int solve(String st) {

        int count0 = 0;
        int count1 = 0;
        int len = st.length();
        int ind = 0;
        char ch0 = '0';
        char ch1 = '1';

        while (ind < len) {

            int ch = st.charAt(ind);

            if (ch != ch0) {
                count0++;
            }

            if (ch != ch1) {
                count1++;
            }
            ch0 = ch0 == '0' ? '1' : '0';
            ch1 = ch1 == '0' ? '1' : '0';
            ind++;
        }


        System.out.println("Start with 0 " + count0);
        System.out.println("Start with 1 " + count1);

        return Math.min(count0, count1);
    }
}
