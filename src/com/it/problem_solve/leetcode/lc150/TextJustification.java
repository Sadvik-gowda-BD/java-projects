package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//68. Text Justification
public class TextJustification {

    public static void main(String[] args) {

        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        String[] words2 = new String[]{"What","must","be","acknowledgment","shall","be"};

        List<String> ans = solve(words2, 16);
        System.out.println(ans);
    }

    public static List<String> solve(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        int width = 0;
        Queue<String> q = new LinkedList<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            String word = words[i];
            if ((width + word.length()) <= maxWidth) {
                q.add(word);
                width = width + word.length() + 1;
            } else {
                int noOfWords = q.size();
                i--;
                StringBuilder sb = new StringBuilder();
                int remainPlace = maxWidth - (width - noOfWords);

                if (noOfWords == 1) {
                    sb.append(q.poll()).append(giveSpace(remainPlace));
                } else {
                    int evenSpace = remainPlace / (noOfWords - 1);
                    int extra = remainPlace % (noOfWords - 1);

                    while (!q.isEmpty()) {
                        String pollWord = q.poll();
                        if (sb.isEmpty()) {
                            sb.append(pollWord);
                        } else {
                            sb.append(giveSpace(evenSpace));
                            if (extra > 0) {
                                sb.append(" ");
                                extra--;
                            }
                            sb.append(pollWord);
                        }
                    }

                }
                ans.add(sb.toString());
                width = 0;
            }
        }

        StringBuilder lastSentence = new StringBuilder();
        while (!q.isEmpty()) {

            if (lastSentence.isEmpty()) {
                lastSentence.append(q.poll());
            } else {
                lastSentence.append(" ").append(q.poll());
            }
        }

        lastSentence.append(giveSpace(maxWidth - lastSentence.length()));
        ans.add(lastSentence.toString());

        return ans;
    }

    private static String giveSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
