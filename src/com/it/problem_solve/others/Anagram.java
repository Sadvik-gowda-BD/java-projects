package com.it.problem_solve.others;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {

        String str1 = "listeno";
        String str2 = "siblent";
        System.out.println(isAnagram(str1, str2));

        System.out.println(isAnagram2(str1,str2));

    }

    //3 approach hashmap, sort, arry[26] and compare
    private static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] str1Array = str1.toCharArray();
        Arrays.sort(str1Array);
        char[] str2Array = str2.toCharArray();
        Arrays.sort(str2Array);
        for (int i = 0; i < str1Array.length; i++) {
            if (str1Array[i] != str2Array[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char ch : str1.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : str2.toCharArray()) {
            count[ch - 'a']--;
        }

        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
