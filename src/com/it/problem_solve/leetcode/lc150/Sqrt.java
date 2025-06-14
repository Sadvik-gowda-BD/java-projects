package com.it.problem_solve.leetcode.lc150;


//69. Sqrt(x)
public class Sqrt {

    public static void main(String[] args) {

        System.out.println(solveByBinarySearch2(5));

//        System.out.println(solveByBinarySearch(8));
    }

    public static int solveByBinarySearch(int x) {
        int l = 1;
        int h = (x / 2) + 1;
        int ans = 0;

        while (l <= h) {
            int mid = (l + h) / 2;
            long val = (long) mid * mid;

            if (val == x) {
                return mid;
            } else if (val < x) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static int solveByBinarySearch2(int x) {
        int l = 1;
        int h = (x / 2) + 1;
        int ans = 0;

        while (l < h) {
            int mid = (l + h) / 2;
            long val = (long) mid * mid;

            System.out.println("l:" + l + " h:" + h + " mid:" + mid);

            if (val == x) {
                return mid;
            } else if (val < x) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        return l;
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
