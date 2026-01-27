package com.it.problem_solve.leetcode.lc150;

import java.util.HashMap;
import java.util.HashSet;

//76. Minimum Window Substring
public class MinWindowSubstring {


    public static void main(String[] args) {

        String s = "ADOBECODEBANC", t = "ABC";

//        System.out.println(solve(s, t));
        System.out.println(solve("abc", "cba"));
//        System.out.println(solve("a", "a"));
//        System.out.println(solve("a", "aa"));
    }


    public static String solve(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }


        int sLen = s.length();
        int tLen = t.length();

        int lp = 0;

        int[] ans = new int[]{Integer.MAX_VALUE, 0, 0}; //{len, lp, rp}

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashSet<Character> reqElements = new HashSet<>();
        HashMap<Character, Integer> currMap = new HashMap<>();

        for (int i = 0; i < tLen; i++) {
            char ch = t.charAt(i);
            reqElements.add(ch);

            int count = tMap.getOrDefault(ch, 0);
            tMap.put(ch, count + 1);
        }

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (!tMap.containsKey(ch)) {
                continue;
            }

            int count = currMap.getOrDefault(ch, 0);
            currMap.put(ch, count + 1);

            if (tMap.get(ch).equals(currMap.get(ch))) {
                reqElements.remove(ch);
            }

            if (reqElements.isEmpty()) {

                while (lp <= i) {
                    char sChar = s.charAt(lp);
                    if (tMap.containsKey(sChar)) {
                        if (currMap.get(sChar).equals(tMap.get(sChar))) {
                            int currSize = i - lp + 1;
                            if (ans[0] > currSize) {
                                ans[0] = currSize;
                                ans[1] = lp;
                                ans[2] = i;
                            }
                            reqElements.add(sChar);
                            currMap.put(sChar, currMap.get(sChar) - 1);

                            lp++;
                            break;
                        } else {
                            currMap.put(sChar, currMap.get(sChar) - 1);
                        }
                    }
                    lp++;
                }
            }

        }

        if (ans[0] == Integer.MAX_VALUE) return "";

        return s.substring(ans[1], ans[2] + 1);
    }
}
