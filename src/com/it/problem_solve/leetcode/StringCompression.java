package com.it.problem_solve.leetcode;

public class StringCompression {

    public static void main(String[] args) {

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        System.out.println(solve(chars));
    }

    private static int solve(char[] chars) {
        int count = 1;
        char preCh = chars[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            char currCh = chars[i];
            if (currCh == preCh) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(preCh).append(count);
                } else {
                    sb.append(preCh);
                }
                count = 1;
                preCh = currCh;
            }
        }

        if (count > 1) {
            sb.append(preCh).append(count);
        } else {
            sb.append(preCh);
        }

        System.out.println(sb.toString());

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();

    }
}
