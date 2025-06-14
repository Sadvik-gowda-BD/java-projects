package com.it.problem_solve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
lt
3343. Count Number of Balanced Permutations
 */
public class CountNumberOfBalancedPermutations {

    public static void main(String[] args) throws Exception {

        String st = "123";

        int len = st.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = st.charAt(i) - '0';
        }
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        permWithDuplicate(arr, new ArrayList<>(), new boolean[len], res);
        int count = 0;
        for (List<Integer> ls : res) {
            if (isOddEvenEqSum(ls)) {
                count++;
            }
        }

        System.out.println(res);
        System.out.println(count);


    }

    private static boolean isOddEvenEqSum(List<Integer> ls) {
        boolean isEven = false;
        int sum = 0;

        for (int num : ls) {
            if (isEven) {
                sum -= num;
            } else {
                sum += num;
            }
            isEven = !isEven;
        }
        return sum == 0;
    }

    /*
    1 1 2
    1 2 1
    1 1 2
     */
    public static void permWithDuplicate(int[] arr, List<Integer> currLis, boolean[] used, List<List<Integer>> ls) {

        if (currLis.size() == arr.length) {
            ls.add(new ArrayList<>(currLis));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) continue;

            currLis.add(arr[i]);
            used[i] = true;
            permWithDuplicate(arr, currLis, used, ls);
            currLis.remove(currLis.size() - 1);
            used[i] = false;
        }
    }

}
