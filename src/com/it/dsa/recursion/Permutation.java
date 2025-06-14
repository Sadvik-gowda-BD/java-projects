package com.it.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
A permutation is a way of selecting and arranging r objects from a set of n distinct objects where the order matters.

Ex: For array {1, 2, 3} possible size 2 permutation are:
[1, 2], [2, 1], [1, 3], [3, 1], [2, 3], [3, 2]

pair (1,2) != (2,1)
 */
public class Permutation {

    static int count = 0;

    public static void main(String[] args) {


        int[] arr = {1, 2, 3};

        System.out.println("Permutation by using visit array and backtrack");
        permutation(arr, new HashSet<>(), new ArrayList<>());

        System.out.println("Permutation by swapping abd backtrack without any extra space");
        int[] arr2 = {1, 2, 3};
        permutationBySwapping(arr2, 0);

        System.out.println("-------permutationWithDuplicate-------------");
        permutationWithDuplicate(arr);
    }

    /*
    For permutation, every element can be picked anytime (remove after picking).
    Permutations : O(n! * n) ---> (n! = generating n! permutations, n=every time looping 0 10 n)
     */
    private static void permutation(int[] arr, Set<Integer> used, List<Integer> currList) {
//        System.out.println(currList);
        if (currList.size() == arr.length) {
            System.out.println(currList);
            return;
        }

        count++;
        for (int i = 0; i < arr.length; i++) {
            if (!used.contains(arr[i])) {
                currList.add(arr[i]);
                used.add(arr[i]);
                permutation(arr, used, currList);
                used.remove(arr[i]);
                currList.remove(currList.size() - 1);
            }
        }
    }

    //it doesn't use any extra space
    public static void permutationBySwapping(int[] arr, int ind) {
        if (ind == arr.length) {
            System.out.println(Arrays.toString(arr));
        }

        for (int i = ind; i < arr.length; i++) {
            swap(arr, i, ind);
            permutationBySwapping(arr, ind + 1);
            swap(arr, ind, i);
        }
    }


    public static void permutationWithDuplicate(int[] arr) {
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        permutationWithDuplicate(arr, used, new ArrayList<>());
    }

    /*

    To handle all permutations of any length while avoiding duplicates, we need to:
        Sort the array first – so duplicates are adjacent.
        Track used indices.
        Skip a duplicate number if:
            It is the same as the previous, and
            The previous hasn't been used in this recursive path.

    Suppose arr = [1, 1, 2]. Without this condition, the following permutations could be generated multiple times:
        [1 (first), 1 (second), 2]
        [1 (second), 1 (first), 2] ← duplicate so use (i > 0 && arr[i] == arr[i - 1]) && !used[i - 1])  condition
     */
    private static void permutationWithDuplicate(int[] arr, boolean[] used, List<Integer> currList) {

        if (!currList.isEmpty()) {
            System.out.println(currList);
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i] || (i > 0 && arr[i] == arr[i - 1]) && !used[i - 1]) {
                continue;
            }

            currList.add(arr[i]);
            used[i] = true;
            permutationWithDuplicate(arr, used, currList);
            currList.remove(currList.size() - 1);
            used[i] = false;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
