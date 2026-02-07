package com.it.problem_solve.leetcode.others;

//647. Palindromic Substrings
public class PalindromicSubstrings {

    public static void main(String[] args) {

        String st = "aaa";
        System.out.println(countSubstrings(st));
    }

    public static int countSubstrings(String st) {

        int totalCount = 0;
        for (int i = 0; i < st.length(); i++) {
            int oddCheck = isPalindrome(st, i, i);
            int evenCheck = isPalindrome(st, i, i + 1);
            totalCount = totalCount + oddCheck + evenCheck;
        }
        return totalCount;
    }

    private static int isPalindrome(String st, int left, int right) {
        int count = 0;
        while (left >= 0 && right < st.length()) {
            if (st.charAt(left) != st.charAt(right)) return count;

            count++;
            left--;
            right++;
        }
        return count;
    }
}
