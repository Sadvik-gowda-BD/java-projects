package com.it.dsa.algorithms.recursion.problems;

public class PowerOfNum {

    public static void main(String[] args) {

        System.out.println(findPow(2, 100));

        System.out.println(findPow2(2, 5, 100));

        //Optimized network
        System.out.println(findPow3(2, 100));

    }

    static long findPow(int m, int n) {

        if (n == 0 || m == 1) {
            return 1;
        }
        return m * findPow(m, n - 1);

    }

    static long findPow2(int m, int n, long ans) {

        if (n == 0 || m == 1) {
            return ans;
        }
        return findPow2(m, n - 1, ans * m);

    }

    static long findPow3(int m, int n) {

        if (n == 0 || m == 1) {
            return 1;
        }

        if (n % 2 == 0){
            return findPow3(m*m, n/2);
        }else {
            return m * findPow3(m*m,  (n-1)/2);
        }
    }
}
