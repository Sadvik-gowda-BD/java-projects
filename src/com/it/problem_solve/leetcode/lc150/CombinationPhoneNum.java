package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//17. Letter Combinations of a Phone Number
public class CombinationPhoneNum {

    public static void main(String[] args) {


        System.out.println(solve("2"));

        System.out.println(solve("23"));
        System.out.println(solve("268"));
    }

    public static List<String> solve(String st) {

        List<String> ans = new ArrayList<>();

        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        rec(map, ans, st, new StringBuilder(), 0);
        return ans;
    }

    private static void rec(HashMap<Character, List<Character>> map, List<String> ans, String digits, StringBuilder sb, int ind) {

        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        List<Character> chars = map.get(digits.charAt(ind));
        for (Character aChar : chars) {
            sb.append(aChar);
            rec(map, ans, digits, sb, ind + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
