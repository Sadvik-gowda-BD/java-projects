package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) throws Exception {

        int[] a1 = {2,4,6};

        solve2(a1);

    }


    public static int solve2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            int pre = n - 1;
            int post = n + 1;

            if(map.containsKey(n)){
                continue;
            }

            if (!map.containsKey(pre) && !map.containsKey(post)) {
                map.put(n, 1);
            } else if (map.containsKey(pre) && !map.containsKey(post)) {
                int val = map.get(pre) + 1;
                map.put(n, val);
                map.put(n - map.get(pre), val);
            } else if (!map.containsKey(pre) && map.containsKey(post)) {
                int val = map.get(post) + 1;
                map.put(n, val);
                map.put(n + map.get(post), val);
            } else {
                int preVal = map.get(pre);
                int postVal = map.get(post);
                int val = preVal + postVal + 1;
                map.put(n, val);
                map.put(n - preVal, val);
                map.put(n + postVal, val);
            }
        }

        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        System.out.println(max);
        return max;
    }

}
