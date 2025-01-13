package com.it.dsa.graph.problems;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
126. Word Ladder II

ample 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
 */
public class WordLadder2 {

    public static void main(String[] args) {


        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        String beginWord2 = "der";
        String endWord2 = "dfs";
        List<String> wordList2 = Arrays.asList("des","der","dfr","dgt","dfs");

        System.out.println(solve(beginWord, endWord, wordList));

        System.out.println(solve(beginWord2, endWord2, wordList2));

    }


    public static List<List<String>> solve(String beginWord, String endWord, List<String> wordList) {


        Set<String> wordSet = new HashSet<>(wordList);
        Queue<List<String>> q = new LinkedList<>();

        q.add(List.of(beginWord));
        List<List<String>> ans = new ArrayList<>();


        while (!q.isEmpty()) {

            int size = q.size();

            while (size > 0) {

                if (q.isEmpty()) {
                    break;
                }

                List<String> currList = q.poll();
                String currWord = currList.get(currList.size() - 1);
                wordSet.remove(currWord);

                if (endWord.equals(currWord)) {

                    if(ans.size() == 0){
                        ans.add(currList);
                    } else if (ans.get(0).size() == currList.size()) {
                        ans.add(currList);
                    }
                    continue;
                }

                char[] ca = currWord.toCharArray();
                for (int i = 0; i < currWord.length(); i++) {
                    char oldChar = ca[i];
                    for (int j = 0; j < 26; j++) {
                        char newChar = (char) ('a' + j);
                        ca[i] = newChar;
                        String newStr = new String(ca);
                        if (wordSet.contains(newStr)) {
                            List<String> ls = new ArrayList<>(currList);
                            ls.add(newStr);
                            q.add(ls);
                        }
                    }
                    ca[i] = oldChar;
                }
                size--;
            }
        }
        return ans;
    }
}
