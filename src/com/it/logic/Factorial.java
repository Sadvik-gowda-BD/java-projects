package com.it.logic;

public class Factorial {

    public static void main(String[] args) {
        int num = 10;
        findFactorialByLoop(num);
        findFactByRecursion(num);
    }

    private static void findFactorialByLoop(int num) {
        int fact = 1;
        while (num > 1) {
            fact *= num;
            num--;
        }
        System.out.println("Facorial of " + num + " by loop is :" + fact);
    }

    private static void findFactByRecursion(int num) {
        System.out.println("Facorial of " + num + " by recurssiom is :" + fact(num));
    }

    private static int fact(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * fact(num - 1);
    }

    /*
    5*fact(4)
    4*fact(3)
    3*fact(2)
    2*fact(1)
    1
     */
}
