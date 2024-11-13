package com.it.dsa.algorithms.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByRecursion {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(20);
        list.add(15);
        list.add(30);
        list.add(5);
        list.add(12);
        list.add(15);

        System.out.println(list);
        sort(list);
        System.out.println(list);
    }

    private static void sort(List<Integer> list) {

        if (list.isEmpty()) {
            return;
        }
        int val = list.remove(list.size() - 1);
        sort(list);
        insert(list, val);
    }

    private static void insert(List<Integer> list, int val) {

        if (list.isEmpty() || val > list.get(list.size() - 1)) {
            list.add(val);
            return;
        }
        int num = list.remove(list.size() - 1);
        insert(list, val);
        list.add(num);
    }
}
