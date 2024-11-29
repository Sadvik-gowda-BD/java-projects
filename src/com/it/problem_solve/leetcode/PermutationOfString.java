package com.it.problem_solve.leetcode;

/*
567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationOfString {

    public static void main(String[] args) {

        System.out.println(solve("ab", "eidbaooo"));
        System.out.println(solve("ab", "eidboaoo"));

    }

    //solve with sliding window
    private static boolean solve(String s1, String s2) {

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        int l1 = s1.length();
        int l2 = s2.length();

        for (int i = 0; i < l1; i++) {
            a1[s1.charAt(i) - 'a'] += 1;
            a2[s2.charAt(i) - 'a'] += 1;
        }


        for (int i = l1; i < l2; i++) {
            if (isFreqEqual(a1, a2)) {
                return true;
            }

            a2[s2.charAt(i - l1) - 'a'] -= 1;
            a2[s2.charAt(i) - 'a'] += 1;
        }

        return isFreqEqual(a1, a2);
    }


    private static boolean isFreqEqual(int[] a1, int[] a2) {

        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }


}
