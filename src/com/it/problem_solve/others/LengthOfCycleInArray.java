package com.it.problem_solve.others;

import java.util.HashMap;

/*
Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element
to the index it points to. Find a cycle and return its length. No cycle is found -> -1.
 */
public class LengthOfCycleInArray {

    public static void main(String[] args) {

        /*
        lengthOfCycle([1, 0], 0); // 2
lengthOfCycle([1, 2, 0], 0); // 3
lengthOfCycle([1, 2, 3, 1], 0); // 3
         */

        int[] arr = {1, 2, 3, 1};
        System.out.println(solve(arr, 0));
    }

    private static int solve(int[] arr, int startIndex) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int ind = startIndex;
        int len = 0;

        while (!map.containsKey(ind)) {

            if (ind < 0 || ind >= arr.length) {
                return -1;
            }
            map.put(ind, len);
            len++;
            ind = arr[ind];
        }

        return len - map.get(ind);
    }
}
