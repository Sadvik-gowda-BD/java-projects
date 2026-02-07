package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

/*
2149. Rearrange Array Elements by Sign
Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
 */
public class RearrangeArrayElementsBySign {

    public static void main(String[] args) {

        int[] nums = {3, 1, -2, -5, 2, -4};

        int[] res = solve(nums);

        System.out.println(Arrays.toString(res));
    }

    private static int[] solve(int[] arr) {

        int[] newArr = new int[arr.length];

        int negIndex = 1;
        int posIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (num < 0) {
                newArr[negIndex] = num;
                negIndex += 2;
            } else {
                newArr[posIndex] = num;
                posIndex += 2;
            }
        }

        return newArr;
    }
}
