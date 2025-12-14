package com.it.problem_solve.leetcode;

/*
5. Longest Palindromic Substring

 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        String s2 = "cbb";
        System.out.println(solve2(s));
        System.out.println(solve2(s2));
    }

    //Brute fore Time complexity : O(n^3). there are n2 sub string
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


    //Time complexity : O(n^2).  Since expanding a palindrome around its center could take O(n) time, the overall complexity is O(n^2).
    public static String solve2(String s) {
        int len = s.length();

        String res = "";
        for (int i = 0; i < len; i++) {

            String oddPal = expandFromCenter(s, i, i); //odd palindrome
            String evenPal = expandFromCenter(s, i, i + 1); //even palindrome

            if (oddPal.length() > res.length()) {
                res = oddPal;
            }
            if (evenPal.length() > res.length()) {
                res = evenPal;
            }

        }
        return res;
    }


    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


}
