package com.it.problem_solve.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//For permutation, every element can be picked anytime (remove after picking).
public class Permutation {

    static int count = 0;
    public static void main(String[] args) {


        int[] arr = {1, 2, 3};
        permutation(arr, new HashSet<>(), new ArrayList<>());
        System.out.println(count);
    }

    /*
    For permutation, every element can be picked anytime (remove after picking).
    Permutations : O(n! * n)
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


}
