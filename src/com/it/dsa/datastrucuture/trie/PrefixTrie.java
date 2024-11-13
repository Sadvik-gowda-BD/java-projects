package com.it.dsa.datastrucuture.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrefixTrie {

    public static TrieNode root;

    public PrefixTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!currNode.contains(ch)) {
                TrieNode newNode = new TrieNode();
                currNode.put(ch, newNode);
            }
            currNode = currNode.getNode(ch);
        }
        currNode.setAsWord();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.contains(ch)) {
                return false;
            }
            node = node.getNode(ch);
        }
        return node.isWord();
    }

    //Returns if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.contains(prefix.charAt(i))) {
                return false;
            }
            node = node.getNode(prefix.charAt(i));
        }
        return true;
    }

    public List<String> startsWithList(String prefix) {

        List<String> ls = new ArrayList<>();
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.contains(prefix.charAt(i))) {
                return Collections.emptyList();
            }
            node = node.getNode(prefix.charAt(i));
        }

        StringBuilder sb = new StringBuilder(prefix);
        addData(node, sb, ls);

        return ls;
    }

    private void addData(TrieNode node, StringBuilder sb, List<String> ls) {
        if (node.isWord()) {
            ls.add(sb.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null) {
                int asci = 'a' + i;
                sb.append((char) (asci));
                addData(node.links[i], sb, ls);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
