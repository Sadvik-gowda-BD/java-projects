package com.it.problem_solve.leetcode.others;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//2131. Longest Palindrome by Concatenating Two Letter Words
public class LongestPalindromeStrByConcat {

    public static void main(String[] args) {

        String[] words = {"lc", "cl", "gg"};
        String[] w2 = {"ab", "ty", "yt", "lc", "cl", "ab"};
        String[] w3 = {"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"};
        //"qo","","","qf","","ff","qq","","of","of","","of","of","qf","qf","of"
        //fofqfo oo  ofqfof

//        System.out.println(solve(words));
//        System.out.println(solve(w2));
        System.out.println(solve(w3));

    }

    public static int solve(String[] words) {
        int ans = 0;

        HashMap<String, Integer> hm = new HashMap<>();

        for (String str : words) {
            String revStr = "" + str.charAt(1) + str.charAt(0);
            if (hm.getOrDefault(revStr, 0) > 0) {
                ans += 4;
                hm.put(revStr, hm.get(revStr) - 1);
            } else {
                hm.put(str, hm.getOrDefault(str, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> es : hm.entrySet()) {
            if (es.getValue() > 0) {
                String str = es.getKey();
                String revStr = "" + str.charAt(1) + str.charAt(0);
                if (str.equals(revStr)) {
                    ans += 2;
                    break;
                }
            }
        }

        return ans;
    }
}
