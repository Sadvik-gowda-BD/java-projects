package com.it.problem_solve.leetcode.others2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//1636. Sort Array by Increasing Frequency
public class SortArrayIncreasingFrequency {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 2, 2, 2, 3};
        solve(arr);
    }

    private static int[] solve(int[] arr) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = arr.length;

        for (int num : arr) {
            int count = hm.getOrDefault(num, 0);
            hm.put(num, count + 1);
        }

        Integer[] arrObj = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arrObj[i] = arr[i];
        }


        Comparator<Integer> comp = (o1, o2) -> {
            if (hm.get(o1).equals(hm.get(o2))) {
                return o2 - o1;
            }
            return hm.get(o1) - hm.get(o2);
        };

        Arrays.sort(arrObj, comp);

        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = arrObj[i];
        }

        return res;
    }

}
