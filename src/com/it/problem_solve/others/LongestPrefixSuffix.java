package com.it.problem_solve.others;

import java.util.List;

public class LongestPrefixSuffix {

    private static String getLongestPrefixSuffix(List<String> list) {
        int index = 0;
        int len = list.size();
        for (int i = 0; i < list.get(0).length(); i++) {
            char ch = list.get(0).charAt(i);
            for (int j = 1; j < len; j++) {
                int strLen = list.get(j).length();
                char ch2 = list.get(j).charAt(i);
                char ch3 = list.get(j).charAt(strLen - 1 - i);
                if (strLen - 1 < i || !isEq(ch2, ch) || !isEq(ch3, ch)) {
                    return list.get(0).substring(0, index);
                }
            }
            index++;
        }
        return list.get(0).substring(0, index);
    }

    private static boolean isEq(char st, char ch) {
        return st == ch;
    }


    public static void main(String[] args) {

        List<String> ls = List.of("aaaba", "aaacba", "aa");

        System.out.println("Longest prefix is :" + getLongestPrefixSuffix(ls));
    }
}
