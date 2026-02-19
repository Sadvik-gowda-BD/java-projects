package com.it.problem_solve.leetcode.lc150;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

//139. Word Break
public class WordBreak {

    public static void main(String[] args) {

        List<String> ls2 = List.of("a","abc","b","cd");
        String s2 = "abcd";

        System.out.println(solveByMemo(s2, ls2));
        System.out.println(solveByTabulation(s2, ls2));

    }


    private static boolean solveByTabulation(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true; //empty string
        Set<String> wordDict = new HashSet<>(dict);


        for (int i = s.length() - 1; i >= 0; i--) {

            for (String word : wordDict) {
                int wordLen = word.length();
                if (i + wordLen > s.length()) continue;

                String subStr = s.substring(i, i + wordLen);
                if (wordDict.contains(subStr)) {
                    if(dp[i + wordLen]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }


    public static boolean solveByMemo(String s, List<String> wordDict) {
        Boolean[] memeo = new Boolean[s.length()];
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict, 0, memeo);
    }

    private static boolean dfs(String s, Set<String> dict, int start, Boolean[] memo) {

        // Base case
        if (start == s.length()) {
            return true;
        }

        // Memo check
        if (memo[start] != null) {
            return memo[start];
        }

        // Try all possible substrings starting from 'start'
        for (int end = start + 1; end <= s.length(); end++) {

            String sub = s.substring(start, end);
            if (dict.contains(sub)) {
                boolean res = dfs(s, dict, end, memo);
                if (res) {
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }


    public static boolean solveByREc(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return solveByREc(s, 0, dict);
    }

    public static boolean solveByREc(String s, int ind, Set<String> dict) {
        if (ind >= s.length()) return true;

        StringBuilder sb = new StringBuilder();

        for (int i = ind; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.contains(sb.toString())) {
                boolean res = solveByREc(s, i + 1, dict);
                if (res) return true;
            }
        }

        return false;
    }


}