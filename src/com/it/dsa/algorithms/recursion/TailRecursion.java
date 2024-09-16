package com.it.dsa.algorithms.recursion;

/*
Tail recursion is defined as a recursive function in which the recursive call is the last statement that is
executed by the function. So basically nothing is left to execute after the recursion call.
 */
public class TailRecursion {

    public static void main(String[] args) {

    }

    private static int factorialByTailRec(int n, int k) {
        if (n == 0 || n == 1) {
            return k;
        }
        return factorialByTailRec(n - 1, n * k);
    }

    static void print(int n) {
        if (n < 0)
            return;

        System.out.print(" " + n);

        // The last executed statement is recursive call
        print(n - 1);
    }


}
