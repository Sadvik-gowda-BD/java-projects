package com.it.problem_solve.others;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        //for k combination
        int k = 3;

        combination(arr, k, 0, new ArrayList<>());
    }

    /*
    For combination, after picking, move forward (no going back).
    TC = O(k × C(n, k))
     */
    private static void combination(int[] arr, int k, int start, List<Integer> currList) {
        if (currList.size() == k) {
            System.out.println(currList);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            currList.add(arr[i]);
            combination(arr, k, i + 1, currList);
            currList.remove(currList.size() - 1);
        }
    }
}
