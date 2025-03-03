package com.it.dsa.others.bitmanpulation;

public class Others {

    public static void main(String[] args) {

        //checkNumIsPowOf2();
        otherTricks();

    }

    private static void checkNumIsPowOf2() {

        int num = 12;

        int result = num & (num - 1);
        System.out.println(result == 0); //false

        num = 16;
        result = num & (num - 1);
        System.out.println(result == 0);
    }

    private static void otherTricks() {

        int n = 20;

        //n>>1 is equal to n/2
        System.out.println(n + "/2 is : " + (n >> 1));

        if ((n & 1) == 1) {
            System.out.println(n + " is Odd");
        } else {
            System.out.println(n + " is Even");
        }

        n = 13;
        if ((n & 1) == 1) {
            System.out.println(n + " is Odd");
        } else {
            System.out.println(n + " is Even");
        }


    }
}
