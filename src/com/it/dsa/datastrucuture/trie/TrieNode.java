package com.it.dsa.datastrucuture.trie;

public class TrieNode {

    public TrieNode[] links = new TrieNode[26];
    public boolean isWord = false;

    public boolean isWord() {
        return isWord;
    }

    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(int ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode getNode(int ch) {
        return links[ch - 'a'];
    }

    public void setAsWord() {
        this.isWord = true;
    }

}
