package com.it.problem_solve.leetcode;

//2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
public class MinEqualSum {

    public static void main(String[] args) {

        int[] arr1 = {0, 17, 20, 17, 5, 0, 14, 19, 7, 8, 16, 18, 6};
        int[] arr2 = {21, 1, 27, 19, 2, 2, 24, 21, 16, 1, 13, 27, 8, 5, 3, 11, 13, 7, 29, 7};

        System.out.println(solve(arr1, arr2));
    }


    public static long solve(int[] a1, int[] a2) {
        long ans = 0;

        int a1Len = a1.length;
        int a2Len = a2.length;

        long a1Sum = 0, a2Sum = 0;
        int a1Zeros = 0, a2Zeros = 0;


        for (int i = 0; i < a1Len; i++) {
            if (a1[i] == 0) a1Zeros++;
            a1Sum += a1[i];
        }

        for (int i = 0; i < a2Len; i++) {
            if (a2[i] == 0) a2Zeros++;
            a2Sum += a2[i];
        }

        System.out.println("a1Sum:" + a1Sum + " a2Sum:" + a2Sum + " a1Zeros:" + a1Zeros + " a2Zeros:" + a2Zeros);

        if (a1Zeros == 0 && a2Zeros == 0) {
            if (a1Sum == a2Sum) {
                return a1Sum;
            }
            return -1;
        }

        if (a1Zeros == 0 && a2Zeros != 0) {
            if (a1Sum < a2Sum || a1Sum < (a2Sum + a2Zeros)) {
                return -1;
            }
        }

        if (a2Zeros == 0 && a1Zeros != 0) {
            if (a2Sum < a1Sum || a2Sum < (a1Sum + a1Zeros)) {
                return -1;
            }
        }

        return Math.max((a1Sum + a1Zeros), (a2Sum + a2Zeros));
    }


}
