package com.it.dsa.datastrucuture.trie;

import java.util.List;

public class DriverClass {

    public static void main(String[] args) {

        PrefixTrie st = new PrefixTrie();

        st.insert("abcdef");
        st.insert("abcghi");
        st.insert("abcjkl");
        st.insert("abxyz");


        System.out.println("search with abc:" + st.search("abc"));
        System.out.println("search with abcghi:" + st.search("abcghi"));
        System.out.println("search with abcjkl:" + st.search("abcjkl"));
        System.out.println("Starts with " + st.startsWith("abcd"));

        List<String> ls = st.startsWithList("abx");

        System.out.println(ls);

    }


}
