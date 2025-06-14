package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationSequenceLeetcode {

    static int count = 0;
    ;

    public static void main(String[] args) {

        int n = 3, k = 3;

        solve(n, k);
    }

    public static String solve(int n, int k) {
        count = k;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        List<Integer> res = rec(arr, new HashSet<>(), new LinkedList<>());
        System.out.println(res);

        if (res == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static List<Integer> rec(int[] arr, Set<Integer> has, LinkedList<Integer> ls) {

        if (ls.size() == arr.length) {
            count--;
            if (count == 0) {
                return ls;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (has.contains(arr[i])) continue;

            ls.add(arr[i]);
            has.add(arr[i]);
            List<Integer> res = rec(arr, has, ls);
            if (res != null) return res;
            has.remove(arr[i]);
            ls.removeLast();
        }
        return null;
    }
}
