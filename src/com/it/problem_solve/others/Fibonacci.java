package com.it.problem_solve.others;

public class Fibonacci {

    //0 1 1 2 3 5 8 .....
    public static void main(String[] args) {
        findNthFibonacci(7);
        System.out.println("------------");
        System.out.println(fibonacciByRecursion(7));
    }

    public static int findNthFibonacci(int n) {
        int a = 0;
        int b = 1;
        int fibNum = 0;

        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return 1;
        }

        System.out.println(a);
        System.out.println(b);

        for (int i = 3; i <= n; i++) {
            fibNum = a + b;
            a = b;
            b = fibNum;
            System.out.println(fibNum);
        }
        return fibNum;
    }

    private static int fibonacciByRecursion(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacciByRecursion(num - 1) + fibonacciByRecursion(num - 2);
    }
}
