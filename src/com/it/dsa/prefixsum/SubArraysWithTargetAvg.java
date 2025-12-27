package com.it.dsa.prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Find all contiguous subArray who's average equal to given target avg
public class SubArraysWithTargetAvg {

    public static void main(String[] args) {

    }

    private static List<List<Integer>> findSubArr(int[] arr, int targetAvg) {
        List<List<Integer>> ans = new ArrayList<>();

        /*
        avg = sum/count; sum = avg*count
        for subarray l to r
        a[l] + a[l+1] ..... a[r] = (r-l+1)*avg
        a[l]-avg + a[l+1]-avg ..... a[r]-avg = 0

        Transformation
        t[i] = a[i]-avg;
         */

        int prefixSum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> ls = new ArrayList<>();
        ls.add(-1);
        map.put(0, ls);

        for (int i = 0; i < arr.length; i++) {
            prefixSum = prefixSum + arr[i] - targetAvg;

            if (map.containsKey(prefixSum)) {
                List<Integer> indices = map.get(prefixSum);
                for (int ind : indices) {
                    int startIndex = ind + 1;
                    System.out.println("SubArray found from " + startIndex + " to " + i);
                }
            }

            //add current index to map

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, new ArrayList<>());
            }
            map.get(prefixSum).add(i);
        }
        return ans;
    }
}
