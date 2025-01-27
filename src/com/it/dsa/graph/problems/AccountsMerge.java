package com.it.dsa.graph.problems;

import com.it.dsa.graph.representation.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
721. Accounts Merge

 */
public class AccountsMerge {

    public static void main(String[] args) {

        List<List<String>> accounts = Arrays.asList(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );

        System.out.println(solve(accounts));

    }

    public static List<List<String>> solve(List<List<String>> accounts) {
        int len = accounts.size();

        DisjointSet ds = new DisjointSet(len);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (map.containsKey(email)) {
                    ds.unionBySize(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> merger = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int parent = ds.findParent(i);
            merger.putIfAbsent(parent, new HashSet<>());
            Set<String> emails = merger.get(parent);
            emails.addAll(getEmails(accounts.get(i)));
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, Set<String>> entry : merger.entrySet()) {

            String name = accounts.get(entry.getKey()).get(0);
            List<String> emailList = new ArrayList<>();
            emailList.add(name);

            Set<String> emails = entry.getValue();
            emailList.addAll(emails);
            result.add(emailList);
        }

        return result;
    }

    private static Set<String> getEmails(List<String> account) {
        Set<String> emailSet = new TreeSet<>();
        for (int i = 1; i < account.size(); i++) {
            emailSet.add(account.get(i));
        }
        return emailSet;
    }
}
