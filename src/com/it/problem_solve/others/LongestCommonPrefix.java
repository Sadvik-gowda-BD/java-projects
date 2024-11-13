package com.it.problem_solve.others;

import java.util.List;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        List<String> ls = List.of("aajab", "aajacb", "aajb");

        System.out.println("Longest prefix is :" + getLongestPrefix(ls));
        System.out.println("Longest prefix is sol2 :" + soln2(ls));
    }

    private static String soln2(List<String> ls) {

        String str = ls.get(0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 1; j < ls.size(); j++) {
                String str2 = ls.get(j);
                if (str2.length() <= i || ch != str2.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();

    }

    private static String getLongestPrefix(List<String> list) {
        int index = 0;
        int len = list.size();
        for (int i = 0; i < list.get(0).length(); i++) {
            char ch = list.get(0).charAt(i);
            for (int j = 1; j < len; j++) {

                if (list.get(j).length() - 1 < i || !isEq(list.get(j).charAt(i), ch)
                        || list.get(len - j).length() - 1 < i || !isEq(list.get(len - j).charAt(i), ch)) {
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

}
