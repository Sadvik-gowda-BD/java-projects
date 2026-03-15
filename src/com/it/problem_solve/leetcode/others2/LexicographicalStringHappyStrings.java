package com.it.problem_solve.leetcode.others2;


import java.util.ArrayList;
import java.util.List;

//1415. The k-th Lexicographical String of All Happy Strings of Length n
public class LexicographicalStringHappyStrings {

    public static void main(String[] args) {

        System.out.println(solve2(3, 9));

    }

    private static String solve2(int n, int k) {

        List<String> list = new ArrayList<>();

        List<Character> chars = List.of('a', 'b', 'c');
        rec2(n, new StringBuilder(), list, chars);

        if (list.size() < k) return "";
        // Collections.sort(list);
        return list.get(k - 1);
    }

    private static void rec2(int n, StringBuilder sb, List<String> ls, List<Character> chars) {

        if (sb.length() == n) {
            ls.add(sb.toString());
            return;
        }

        for (char ch : chars) {
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != ch) {
                sb.append(ch);
                rec2(n, sb, ls, chars);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }


    private static String solve(int n, int k) {

        List<String> list = new ArrayList<>();

        rec1(n, new StringBuilder(), list);

        if (list.size() < k) return "";
        Collections.sort(list);
        return list.get(k - 1);
    }

    private static void rec1(int n, StringBuilder sb, List<String> ls) {

        if (sb.length() == n) {
            ls.add(sb.toString());
            return;
        }

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) != 'a') {
            sb.append('a');
            rec1(n, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) != 'b') {
            sb.append('b');
            rec1(n, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) != 'c') {
            sb.append('c');
            rec1(n, sb, ls);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
