package com.it.problem_solve.leetcode.lc150;


//97. Interleaving String
public class InterleavingString {

    public static void main(String[] args) {


//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";

        System.out.println(solveByRec(s1, s2, s3));

    }

    public static boolean solveByRec(String a, String b, String c) {

        return dfs(a, b, c, 0, 0, 0, false, 0, 0);
    }

    public static boolean dfs(String a, String b, String c, int aInd, int bInd, int cInd, boolean isSplitA,
                              int aSplit, int bSplit) {

        if (cInd == c.length()) {
            if (Math.abs(aSplit - bSplit) <= 1 && aInd == a.length() && bInd == b.length()) {
                return true;
            }
            return false;
        }

        char cChar = c.charAt(cInd);

        if (aInd < a.length() && a.charAt(aInd) == cChar) {
            boolean res;
            if (isSplitA) {
                res = dfs(a, b, c, aInd + 1, bInd, cInd + 1, true, aSplit, bSplit);
            } else {
                res = dfs(a, b, c, aInd + 1, bInd, cInd + 1, true, aSplit + 1, bSplit);
            }
            if (res) return true;
        }

        if (bInd < b.length() && b.charAt(bInd) == cChar) {
            boolean res;
            if (!isSplitA) {
                res = dfs(a, b, c, aInd, bInd + 1, cInd + 1, false, aSplit, bSplit);
            } else {
                res = dfs(a, b, c, aInd, bInd + 1, cInd + 1, false, aSplit, bSplit + 1);
            }
            if (res) return true;
        }

        return false;
    }

}
