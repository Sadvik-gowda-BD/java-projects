package com.it.dsa.datastrucuture.trie.problems;

import com.it.dsa.datastrucuture.trie.PrefixTrie;

public class SearchWordDataStruct {

    public static void main(String[] args) {

        SearchWordDataStruct pt = new SearchWordDataStruct();

        pt.addWord("ab");

        //System.out.println(pt.search("abc"));
        System.out.println(pt.search("a."));


    }

    TrieNode base = new TrieNode();

    public void addWord(String st) {
        int len = st.length();
        TrieNode currNode = base;
        for (int i = 0; i < len; i++) {
            int ind = st.charAt(i) - 'a';

            TrieNode node;
            if (currNode.arr[ind] == null) {
                node = new TrieNode();

            } else {
                node = currNode.arr[ind];
            }

            if (i == len - 1) {
                node.isWord = true;
            }
            currNode.arr[ind] = node;
            currNode = node;
        }
    }

    public boolean search(String word) {
        return searchDot(base, word, 0);
    }

    //TODO: Reduce lines
    public boolean searchDot(TrieNode root, String st, int start) {
        int len = st.length();

        if (start >= len) return false;

        char ch = st.charAt(start);
        if (ch != '.') {
            int ind = ch - 'a';
            TrieNode node = root.arr[ind];
            if (node == null) return false;

            if (start == len - 1 && node.isWord) {
                return true;
            } else {
                return searchDot(node, st, start + 1);
            }
        } else {
            TrieNode[] nodes = root.arr;
            for (int j = 0; j < 26; j++) {
                TrieNode node = nodes[j];
                if (node != null) {
                    if (start == len - 1 && node.isWord) {
                        return true;
                    }
                    boolean res = searchDot(node, st, start + 1);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}

class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean isWord;
}