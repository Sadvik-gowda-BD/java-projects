package com.it.problem_solve.leetcode.others2;


//1758. Minimum Changes To Make Alternating Binary String
public class MinimumChangesMakeAlternatingBinaryString {

    public static void main(String[] args) {

        System.out.println(solve("0100"));
        System.out.println(solve2("0100"));
    }

    private static int solve(String s) {

        char startWithZeroExp = '0';
        char startWithOneExp = '1';

        int startWithZeroCount = 0;
        int startWithOneCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != startWithZeroExp) {
                startWithZeroCount++;
            }

            if (ch != startWithOneExp) {
                startWithOneCount++;
            }
            startWithZeroExp = (startWithZeroExp == '0') ? '1' : '0';
            startWithOneExp = (startWithOneExp == '0') ? '1' : '0';

        }

        return Math.min(startWithOneCount, startWithZeroCount);
    }

    private static int solve2(String s) {

        char startWithZeroExp = '0';

        int startWithZeroCount = 0;
        int startWithOneCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != startWithZeroExp) {
                startWithZeroCount++;
            }else {
                startWithOneCount++;
            }

            startWithZeroExp = (startWithZeroExp == '0') ? '1' : '0';
        }

        return Math.min(startWithOneCount, startWithZeroCount);
    }




}
