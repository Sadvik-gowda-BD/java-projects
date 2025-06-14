package com.it.problem_solve.leetcode;


//3335. Total Characters in String After Transformations I
public class StringTransformation1 {

    public static void main(String[] args) {

    }



    //TODO: Solve by DP
    public static int solveByBruteforce(String st, int t) {
        int MOD = 1_000_000_007;

        StringBuilder sb = new StringBuilder(st);
        while (t > 0) {
            replace(sb);
            t--;
        }

        return sb.length() % MOD;
    }

    private static StringBuilder replace(StringBuilder sb) {

        for (int i = 0; i < sb.length(); i++) {
            int currChar = sb.charAt(i);
            String replaceStr = null;
            if (currChar == 'z') {
                replaceStr = "ab";
                sb.replace(i, i + 1, replaceStr);
                i++;
            } else {
                replaceStr = String.valueOf((char) (currChar + 1));
                sb.replace(i, i + 1, replaceStr);
            }
        }

        return sb;
    }

}
