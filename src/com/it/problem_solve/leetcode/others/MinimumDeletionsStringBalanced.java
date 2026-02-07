package com.it.problem_solve.leetcode.others;


//1653. Minimum Deletions to Make String Balanced
public class MinimumDeletionsStringBalanced {

    public static void main(String[] args) {
        System.out.println(solve("baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"));
        System.out.println(solveByGreedy("baababbaabbaaabaabbabbbabaaaaaabaabababaaababbb"));
    }

    private static int solveByGreedy(String st) {

        int res = 0;
        int bCount = 0;

        for (char ch : st.toCharArray()) {

            if (ch == 'b') {
                bCount++;
            } else { //when ch is 'a'

                if (bCount > 0) {
                    res++;
                    bCount--;
                }
            }
        }
        return res;
    }

    private static int solve(String st) {

        int len = st.length();
        int aCount = 0;
        int bCount = 0;
        int removeCount = 0;
        for (int i = 0; i < len; i++) {
            if (st.charAt(i) == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        int l = 0;
        int r = len - 1;
        while (l < r) {

            while (st.charAt(l) == 'a' && l < r) {
                l++;
                aCount--;
            }

            while (st.charAt(r) == 'b' && r > l) {
                r--;
                bCount--;
            }

            if (l >= r) break;

            if (aCount >= bCount) {
                removeCount++;
                l++;
                bCount--;
            } else {
                removeCount++;
                r--;
                aCount--;
            }
        }

        return removeCount;

    }
}
