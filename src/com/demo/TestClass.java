package com.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;


public class TestClass extends Test2 {

    public static void main(String[] args) {

        HashSet<Integer> set = new LinkedHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);
        set.remove(1);
        set.add(1);
        System.out.println(set);

        Iterator<Integer> it = set.iterator();
//        System.out.println(it.next());
        //it.remove();

        set.remove(it.next());
        System.out.println(set);

    }


    private static int solve(int[] arr, int startInd) {
        int len = 0;
        boolean[] vis = new boolean[arr.length];

        while (true) {
            vis[startInd] = true;
            startInd = arr[startInd];

            if (startInd < 0 || startInd >= arr.length) {
                return -1;
            }

            if (vis[startInd]) {
                return ++len;
            }
            len++;

        }
    }

    private static int byUsingFastSlowPointer(int[] arr, int startIndex) {
        int s = arr[startIndex];
        int f = arr[arr[startIndex]];
        int count = 1;

        while (s != f) {
            if (f >= arr.length || f < 0) {
                return -1;
            }
            s = arr[s];
            f = arr[arr[f]];
            count++;
        }

        return count;
    }


}
