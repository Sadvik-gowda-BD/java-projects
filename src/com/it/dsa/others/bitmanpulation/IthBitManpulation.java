package com.it.dsa.others.bitmanpulation;

//check ith bit is set or not, set means 1

public class IthBitManpulation {


    public static void main(String[] args) {

//        checkIthBitByLeftShift();
//        checkIthBitByRightShift();

        //setIthBitAs1();
//        setIthBitAs0();
        //toggleIthBitByXor();
        removeRightmostSetBit();

    }

    private static void checkIthBitByLeftShift() {
        int num = 13; //00...01101

        int i;
        boolean result;

        System.out.println("Check by Left shift");

        i = 1;
        result = (num & (1 << i)) > 0;
        System.out.println(result);

        i = 2;
        result = (num & (2 << i)) > 0;
        System.out.println(result);
    }

    private static void checkIthBitByRightShift() {
        int num = 13; //00...01101

        int i;
        boolean result;

        System.out.println("Check by Right shift");

        System.out.println("Check by AND operator");
        i = 1;
        result = ((num >> i) & 1) == 1;
        System.out.println(result);

        i = 2;
        result = ((num >> i) & 1) == 1;
        System.out.println(result);

        System.out.println("Check by odd and even");
        i = 1;
        result = (num >> i) % 2 != 0;
        System.out.println(result);

        i = 2;
        result = (num >> i) % 2 != 0;
        System.out.println(result);
    }

    // by OR operator
    private static void setIthBitAs1() {

        int n = 9; //1001
        System.out.println("set nth bit as 1");

        int i;
        int result;

        i = 1; //expect is 11
        result = (1 << i) | n;
        System.out.println(result);

        i = 2; //expect is 13
        result = (1 << i) | n;
        System.out.println(result);

    }

    // by AND operator
    private static void setIthBitAs0() {

        int n = 13; //1101
        System.out.println("set nth bit as 1");

        int i;
        int result;

        i = 0; //expect 12
        result = (~(1 << i) & n);
        System.out.println(result);

        i = 2; //expect 9
        result = (~(1 << i) & n);
        System.out.println(result);
    }

    //set ith bit 0 to 1 and 1 to 0
    private static void toggleIthBitByXor() {

        int n = 13; //1101
        System.out.println("set nth bit as 1");

        int i;
        int result;

        i = 1; //expected 15
        result = (n ^ (1 << i));
        System.out.println(result);

        i = 2; //expected 9
        result = (n ^ (1 << i));
        System.out.println(result);

    }

    private static void removeRightmostSetBit(){

        int num = 12;//1100

        int result = num & (num-1);
        System.out.println(result); // expected 8
    }


}
