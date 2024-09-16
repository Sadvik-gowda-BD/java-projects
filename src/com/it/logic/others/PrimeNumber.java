package com.it.logic.others;

public class PrimeNumber {
    public static void main(String[] args) throws Exception {
        printPrimeNumberUptoN(20); //O(n^2)

        /*
        If a number ‘n’ is not divided by any number less than or equals to the square root of n then,
        it will not be divided by any other number greater than the square root of n.
        So, we only need to check up to the square root of n.
         */
        printPrimeNumberUptoNOptimize(20); //O(n^3/2)
    }

    private static void printPrimeNumberUptoN(int n) throws Exception {
        if (n < 2) {
            throw new Exception("Invalid number");
        }
        for (int i = 2; i < n + 1; i++) {
            if (isPrimeNum(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrimeNum(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printPrimeNumberUptoNOptimize(int n) throws Exception {
        if (n < 2) {
            throw new Exception("Invalid number");
        }
        System.out.print("Optimized way : ");
        for (int i = 2; i < n + 1; i++) {
            if (isPrimeNumOptimize(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isPrimeNumOptimize(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
