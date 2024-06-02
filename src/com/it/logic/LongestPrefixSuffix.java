package com.it.logic;

import java.util.List;

public class LongestPrefixSuffix {

    private static String getLongestPrefixSuffix(List<String> list) {
        int index = 0;
        int len = list.size();
        for (int i = 0; i < list.get(0).length(); i++) {
            char ch = list.get(0).charAt(i);
            for (int j = 1; j < len; j++) {
                int strLen = list.get(j).length();

                if (strLen-1 < i || !isEq(list.get(j).charAt(i), ch)
                        || !isEq(list.get(j).charAt(strLen - i-1), ch)) {
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
