package com.demo;

import com.it.dsa.datastrucuture.binarytree.BinaryNode;
import com.it.dsa.datastrucuture.linkedlist.ListNode;
import com.it.dsa.datastrucuture.stack.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Test1 {


    public static void main(String[] args) throws Exception {


        Trie t = new Trie();
        //t.insert("ab");
        t.insert("a");

        //System.out.println(t.search("ab"));

        System.out.println(t.searchDot(t.base, ".", 0));

    }

}

class Trie {

    TrieNode base = new TrieNode();

    public boolean startsWith(String st) {

        int len = st.length();
        TrieNode currNode = base;
        for (int i = 0; i < len; i++) {
            int ind = st.charAt(i) - 'a';
            TrieNode node = currNode.arr[ind];

            if (node == null) {
                return false;
            }
            if (i == len - 1) {
                return true;
            }
            currNode = node;
        }

        return false;
    }

    public void insert(String st) {
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

    public boolean searchDot(TrieNode root, String st, int start) {
        int len = st.length();

        for (int i = start; i < len; i++) {
            char ch = st.charAt(i);
            if (ch != '.') {
                int ind = ch - 'a';
                TrieNode node = root.arr[ind];
                if (node == null) return false;

                if (start == len - 1 && node.isWord) {
                    System.out.println("--------");
                    return true;
                } else {
                    return searchDot(node, st, i + 1);
                }
            } else {
                TrieNode[] nodes = root.arr;
                for (int j = 0; j < 26; j++) {
                    TrieNode node = nodes[j];
                    if (node != null) {
                        if (i == len - 1 && node.isWord) {
                            return true;
                        }
                        boolean res = searchDot(node, st, i + 1);
                        if (res) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        return false;
    }

    public boolean search(String st) {
        int len = st.length();

        TrieNode currNode = base;
        for (int i = 0; i < len; i++) {
            int ind = st.charAt(i) - 'a';

            TrieNode node = currNode.arr[ind];

            if (node == null) {
                return false;
            }
            if (i == len - 1 && node.isWord) {
                return true;
            }
            currNode = node;
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] arr = new TrieNode[26];
    boolean isWord;
}
