package com.it.problem_solve.leetcode;


//3024. Type of Triangle
public class TypeOfTriangle {

    public static void main(String[] args) {

    }

    public static String solve(int[] arr) {

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (!isValid(a, b, c)) {
            return "none";
        }

        if (a == b && b == c) {
            return "equilateral";
        } else if ((a == b || b == c || a == c)) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    private static boolean isValid(int a, int b, int c) {
        return ((a + b) > c && (b + c) > a && (a + c) > b);
    }
}
