package com.it.problem_solve.leetcode.others;

import java.util.List;

//139. Word Break
public class WordBreak {

    public static void main(String[] args) {


        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");
        wordBreak(s, wordDict);
        System.out.println();
    }


    public static boolean wordBreak(String s, List<String> wordDict) {

        List<String> words = wordDict.stream().sorted((a, b) -> b.length() - a.length()).toList();

        StringBuilder sb = new StringBuilder(s);




        return true;
    }
}
