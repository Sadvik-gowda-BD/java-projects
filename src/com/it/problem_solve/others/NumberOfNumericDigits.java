package com.it.problem_solve.others;

public class NumberOfNumericDigits {

    public static void main(String[] args) {
        String str = "AB1C56D7";
        System.out.println(getNumberOfDigits(str));
        System.out.println(getNumberOfDigits2(str));
    }

    private static int getNumberOfDigits(String str) {
        int digits = 0;
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.charAt(i);
            //ASCII 48 57
            if (ascii >= 48 && ascii <= 57) {
                digits++;
            }
        }
        return digits;
    }

    private static int getNumberOfDigits2(String str) {
        int digits = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //ASCII 48 57
            if (Character.isDigit(ch)) {
                digits++;
            }
        }
        return digits;
    }
}
