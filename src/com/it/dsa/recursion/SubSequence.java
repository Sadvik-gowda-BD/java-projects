package com.it.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

/*
A subsequence is formed by deleting some (or no) elements from the original array without changing the order of the
remaining elements.

Every subsequence is a subset, but not every subset is a subsequence.
Because in subset order not matters like combination.

For array [1, 2, 3], possible subsequences are:
[1, 2], [1, 3], [2, 3], [1], [2], [3], [1, 2, 3], and [].
 */
public class SubSequence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        subSequence(arr, new ArrayList<>(), 0);

        System.out.println("\n----------------------------\n");

        subsequenceApproach2(arr, new ArrayList<>(), 0);
    }

    //pick not-pick logic
    public static void subSequence(int[] arr, List<Integer> list, int index) {

        if (index >= arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        subSequence(arr, list, index + 1);
        list.remove(list.size() - 1);
        subSequence(arr, list, index + 1);
    }

    //for loop logic
    //Time complexity: O(2^n)
    public static void subsequenceApproach2(int[] arr, List<Integer> current, int start) {

        System.out.println(current);

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            subsequenceApproach2(arr, current, i + 1);  // Include the current element and move forward
            current.remove(current.size() - 1);  // Backtrack to exclude the current element
        }
    }


}
