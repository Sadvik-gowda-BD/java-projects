package com.it.problem_solve.leetcode;

/*
5. Longest Palindromic Substring

 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        String s2 = "cbb";
        System.out.println(solve(s));
        System.out.println(solve(s2));
    }

    public static String solve(String s) {
        String longestPal = "";
        int len = s.length();

        for (int k = 0; k < len; k++) {
            for (int i = k + 1; i <= len; i++) {
                String subStr = s.substring(k, i);

                if (isPalindrome(subStr) && subStr.length() > longestPal.length()) {
                    longestPal = subStr;
                }
            }
        }
        return longestPal;
    }

    private static boolean isPalindrome(String st) {
        int left = 0;
        int right = st.length() - 1;
        while (left < right) {
            if (st.charAt(left) != st.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
