package com.it.logic;

public class DecimalToBinary {

    public static void main(String[] args) {
        int num = 4;
        System.out.println("Binary num is:" + convertDecimalToBinary(num));
    }

    //TODO logic might wrong
    public static String convertDecimalToBinary(int num) {
        //4 -> 100
        String binStr = "";
        for (int i = 0; num > 0; i++) {
            num = num / 2;
            binStr += num % 2;
        }
        return binStr;
    }
}
