package com.it.problem_solve.leetcode.others;


import java.util.Stack;

//962. Maximum Width Ramp
public class MaximumWidthRamp {

    public static void main(String[] args) {

        int[] arr = new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1};

        System.out.println(bruteForce(arr));
        System.out.println(solveByMonotonicDecrease(arr));
        System.out.println(solveByMonotonicIncrease(arr));
    }

    private static int bruteForce(int[] arr) {
        int len = arr.length;

        int max = 0;
        for (int i = 0; i < len; i++) {
            if ((len - 1 - i) <= max) break;
            for (int j = len - 1; j > i; j--) {
                if (arr[i] <= arr[j]) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }
        return max;
    }

    //Monotonic stack
    private static int solveByMonotonicDecrease(int[] arr) {

        int len = arr.length;
        int max = 0;

        //Monotonic decreasing order
        Stack<Integer> leftCandidates = new Stack<>();//ele, ind

        for (int i = 0; i < len; i++) {
            if (leftCandidates.isEmpty()) {
                leftCandidates.push(i);
            } else if (arr[i] < arr[leftCandidates.peek()]) {
                leftCandidates.push(i);
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            int currEle = arr[i];
            if (leftCandidates.isEmpty()) return max;
            while (arr[leftCandidates.peek()] <= currEle) {
                max = Math.max(max, i - leftCandidates.pop());
                if (leftCandidates.isEmpty()) return max;
            }
        }

        return max;
    }

    //Monotonic stack other way
    private static int solveByMonotonicIncrease(int[] arr) {

        int len = arr.length;
        int max = 0;

        //Monotonic increasing order
        Stack<Integer> rightCandidates = new Stack<>();//ele, ind

        for (int i = len - 1; i >= 0; i--) {

            if (rightCandidates.isEmpty()) {
                rightCandidates.push(i);
            } else if (arr[i] > arr[rightCandidates.peek()]) {
                rightCandidates.push(i);
            }
        }

        for (int i = 0; i < len; i++) {
            int currEle = arr[i];

            while (!rightCandidates.isEmpty() && currEle <= arr[rightCandidates.peek()]) {
                max = Math.max(max, rightCandidates.pop() - i);
            }
        }

        return max;
    }


}
