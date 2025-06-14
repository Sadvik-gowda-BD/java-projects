package com.it.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/*
A combination is a way of selecting items from a group, where the order of selection does not matter.
A combination is a way of selecting r objects from a set of n distinct objects without regard to the order in which they are selected.

Ex: For array {1, 2, 3} possible size 2 combination are:
[1, 2], [1, 3], [2, 3]

pair (1,2) != (2,1)
*/
public class Combination {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        //for k combination
        int k = 3;

        combination(arr, k, 0, new ArrayList<>());

        System.out.println("\n------------------\n");
        combinationLogic2(arr, new ArrayList<>(), 0, k);
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
            combination(arr, k, i + 1, currList); // Include the current element and move forward
            currList.remove(currList.size() - 1);  // Backtrack to exclude the current element
        }
    }

    //pick not pick logic
    public static void combinationLogic2(int[] arr, List<Integer> list, int index, int size) {

        if (list.size() == size) {
            System.out.println(list);
            return;
        }

        if (index >= arr.length) {
            return;
        }

        list.add(arr[index]);
        combinationLogic2(arr, list, index + 1, size); //pick
        list.remove(list.size() - 1);
        combinationLogic2(arr, list, index + 1, size); //not pick
    }
}
