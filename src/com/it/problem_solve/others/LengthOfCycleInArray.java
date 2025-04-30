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
        System.out.println(solveByHashMap(arr, 0));
        System.out.println(byUsingFastSlowPointer(arr, 0)); // Easy
    }

    private static int solveByHashMap(int[] arr, int startIndex) {

        //Here map works as visited array along with length
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
