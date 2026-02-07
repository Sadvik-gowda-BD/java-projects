package com.it.problem_solve.leetcode.others;


import java.util.HashSet;
import java.util.Set;

//41. First Missing Positive
public class FirstMissingPositive {

    public static void main(String[] args) {

        int[] arr1 = {3, 4, -1, 1};
        int[] arr2 = {1, 2, 0};

        System.out.println(solve(arr1));
        System.out.println(solve(arr2));

        System.out.println("\nApproach 2");
        System.out.println(solve2(arr1));
        System.out.println(solve2(arr2));

        System.out.println("\nApproach 3");
        System.out.println(solve3(arr1));
        System.out.println(solve3(arr2));
    }

    public static int solve(int[] arr) {

        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                set.add(arr[i]);
                max = Math.max(arr[i], max);
            }
        }

        if (set.isEmpty()) return 1;

        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max + 1;
    }

    public static int solve2(int[] arr) {

        int len = arr.length;
        ;

        for (int i = 0; i < len; i++) {
            if ((arr[i] <= 0) || arr[i] == (i + 1) || arr[i] > len) continue;
            rec(arr, arr[i]);
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != (i + 1)) return (i + 1);
        }

        return arr.length + 1;
    }

    private static void rec(int[] arr, int val) {
        if ((val <= 0) || (val > arr.length)) return;
        if (arr[val - 1] == val) return;

        int nextVal = arr[val - 1];
        arr[val - 1] = val;
        rec(arr, nextVal);
    }

    public static int solve3(int[] arr) {

        int index = 0;
        int len = arr.length;

        while (index < len) {

            int correctPlace = arr[index] - 1;

            if (correctPlace < 0 || correctPlace >= len || arr[correctPlace] == arr[index]) {
                index++;
            } else {
                int temp = arr[correctPlace];
                arr[correctPlace] = arr[index];
                arr[index] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int expVal = i + 1;
            if (arr[i] != expVal) return expVal;
        }
        return len + 1;

    }
}
