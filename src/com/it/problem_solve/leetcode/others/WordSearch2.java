package com.it.problem_solve.leetcode.others;


import java.util.ArrayList;
import java.util.List;

//212. Word Search II
public class WordSearch2 {

    public static void main(String[] args) {

        System.out.println();

        char[][] board = new char[][]{{'o', 'a', 'a', 'n' }, {'e', 't', 'a', 'e' }, {'i', 'h', 'k', 'r' }, {'i', 'f', 'l', 'v' }};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        char[][] board2 = new char[][]{{'a', 'b' }, {'c', 'd' }};
        String[] words2 = new String[]{};
        System.out.println(solve(board, words));

    }

    public static List<String> solve(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();
        Trie trie = new Trie();

        for (String word : words) {
            trie.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] vis = new boolean[board.length][board[0].length];
                dfs(board, trie.getHead(), i, j, vis, res, new StringBuilder());

            }
        }
        return res;
    }

    private static void dfs(char[][] board, TrieNode node, int i, int j, boolean[][] vis, List<String> res,
                            StringBuilder sb) {

        if (!isValidCord(board, i, j) || vis[i][j]) {
            return;
        }

        char ch = board[i][j];
        if (node == null || node.node[getIndex(ch)] == null) return;

        sb.append(ch);
        vis[i][j] = true;
        TrieNode currNode = node.node[getIndex(ch)];
        if (currNode.isWord) {
            res.add(sb.toString());
            currNode.RemoveWord();
        }

        dfs(board, currNode, i - 1, j, vis, res, sb);
        dfs(board, currNode, i + 1, j, vis, res, sb);
        dfs(board, currNode, i, j - 1, vis, res, sb);
        dfs(board, currNode, i, j + 1, vis, res, sb);

        sb.deleteCharAt(sb.length() - 1);
        vis[i][j] = false;
    }

    private static int getIndex(char ch) {
        return ch - 'a';
    }

    private static boolean isValidCord(char[][] arr, int i, int j) {
        return i >= 0 && j >= 0 && i < arr.length && j < arr[0].length;
    }


}

class Trie {
    private TrieNode head;

    public Trie() {
        this.head = new TrieNode();
    }

    public TrieNode getHead() {
        return this.head;
    }

    public void addWord(String word) {
        TrieNode currNode = head;
        for (char ch : word.toCharArray()) {
            int ind = ch - 'a';
            if (currNode.node[ind] == null) {
                TrieNode node = currNode.addChar(ch);
                currNode.node[ind] = node;
            }
            currNode = currNode.node[ind];
        }
        currNode.setWord();
    }

    public List<String> startWith(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode currNode = head;
        for (char ch : prefix.toCharArray()) {
            currNode = currNode.node[ch - 'a'];
        }
        StringBuilder sb = new StringBuilder(prefix);
        addString(currNode, res, sb);

        return res;
    }

    private void addString(TrieNode node, List<String> res, StringBuilder sb) {
        if (node == null) return;
        if (node.isWord) {
            res.add(sb.toString());
        }

        TrieNode[] nodes = node.node;
        for (int i = 0; i < 26; i++) {

            if (nodes[i] != null) {
                char ch = (char) ('a' + i);
                sb.append(ch);
                addString(nodes[i], res, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

class TrieNode {
    TrieNode[] node = new TrieNode[26];
    boolean isWord;

    public void setWord() {
        this.isWord = true;
    }

    public void RemoveWord() {
        this.isWord = false;
    }

    public TrieNode addChar(int ch) {
        int ind = ch - 'a';
        TrieNode newNode = new TrieNode();
        this.node[ind] = newNode;
        return newNode;
    }
}