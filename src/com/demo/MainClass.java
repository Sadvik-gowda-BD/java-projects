package com.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) throws Exception {

    }

    private static void test(Integer i){

        i=10000;
        System.out.println(i);
    }


    private static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * fact(n - 1);
    }

    private static int tailRec(int n, int k) {
        if (n == 0 || n == 1) {
            return k;
        }

        return tailRec(n - 1, n * k);
    }


    public static int minimizeCost(List<Integer> list) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        int cost = 0;
        int temp = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            temp = n1 + n2;
            cost += temp;

            pq.add(temp);
        }
        return cost;

    }


}
