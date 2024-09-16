package com.it.logic.others;

public class DecimalToBinary {

    public static void main(String[] args) {
        int num = 4;
        System.out.println("Binary num is:" + convertDecimalToBinary(num));
    }

    public static String convertDecimalToBinary(int num) {
        //4 -> 100
        StringBuilder binStr = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            num = num / 2;
            binStr.append(num % 2);
        }
        return binStr.toString();
    }
}
