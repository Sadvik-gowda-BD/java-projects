package com.it.problem_solve.leetcode.lc150;


//97. Interleaving String
public class InterleavingString {

    public static void main(String[] args) {


//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        System.out.println(solveByRec(s1, s2, s3));
        System.out.println(solveByMemo(s1, s2, s3));

    }

    public static boolean solveByMemo(String s1, String s2, String s3) {

        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solveByMemo(s1, s2, s3, 0, 0, dp);
    }

    public static boolean solveByMemo(String s1, String s2, String s3, int s1Ind, int s2Ind, Boolean[][] dp) {

        int s3Ind = s1Ind + s2Ind;

        if (s3Ind == s3.length()) {
            return true;
        }

        if (dp[s1Ind][s2Ind] != null) {
            return dp[s1Ind][s2Ind];
        }

        boolean res = false;
        char s3Char = s3.charAt(s3Ind);
        if (s1Ind < s1.length() && s1.charAt(s1Ind) == s3Char) {
            res = solveByMemo(s1, s2, s3, s1Ind + 1, s2Ind, dp);
        }

        if (!res && s2Ind < s2.length() && s2.charAt(s2Ind) == s3Char) {
            res = solveByMemo(s1, s2, s3, s1Ind, s2Ind + 1, dp);
        }

        dp[s1Ind][s2Ind] = res;

        return res;
    }


    public static boolean solveByRec(String s1, String s2, String s3) {

        return solveByRec(s1, s2, s3, 0, 0, 0, 0, false);
    }

    public static boolean solveByRec(String s1, String s2, String s3, int s1Ind, int s2Ind, int s1Part,
                                     int s2Part, boolean isPreS1) {

        int s3Ind = s1Ind + s2Ind;

        if (s3.length() == s3Ind) {
            if (Math.abs(s1Part - s2Part) <= 1 && s1.length() == s1Ind && s2.length() == s2Ind) {
                return true;
            }
            return false;
        }

        int s3Char = s3.charAt(s3Ind);

        if (s1Ind < s1.length() && s1.charAt(s1Ind) == s3Char) {
            int partition = isPreS1 ? s1Part : s1Part + 1;
            boolean res = solveByRec(s1, s2, s3, s1Ind + 1, s2Ind, partition, s2Part, true);
            if (res) return true;
        }

        if (s2Ind < s2.length() && s2.charAt(s2Ind) == s3Char) {
            int partition = isPreS1 ? s2Part + 1 : s2Part;
            boolean res = solveByRec(s1, s2, s3, s1Ind, s2Ind + 1, s1Part, partition, false);
            if (res) return true;
        }

        return false;
    }

}
