package com.it.problem_solve.leetcode.lc150;


//69. Sqrt(x)
public class Sqrt {

    public static void main(String[] args) {

        int a = 46340 * 46340;
//        System.out.println(a);
//        System.out.println(Integer.MAX_VALUE);
        //System.out.println(bruteFore(2147483647));
//        System.out.println(solveByBinarySearch(2147483647));
//        System.out.println(solveByBinarySearch(1));
//        System.out.println(solveByBinarySearch(4));
        System.out.println(solveByBinarySearch(8));
    }

    public static int solveByBinarySearch(int x) {
        int l = 1;
        int h = (x / 2) + 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            long val = (long) mid * mid;

            if (val == x) {
                return mid;
            } else if (val < x) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return h; //When the loop ends, hi contains the largest integer whose square is ≤ x, so we return hi instead of -1.
    }

    public static int bruteFore(int x) {
        int lim = x / 2;
        int num = 1;

        while (num <= lim + 1) {
            long val = (long) num * num;
            if (num > 46335 && num <= 46343) {
                System.out.println("Num:" + num + " val: " + val);
            }
            if (val == x) return num;
            if (val > x) break;
            num++;
        }
        return num - 1;
    }
}
