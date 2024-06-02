package com.it.logic;

public class NumberToDigitConversion {

    public static void main(String[] args) {
        String strNums = "one two three double five six triple one double one zero";
        String digits = convertToDigit(strNums);
        System.out.println(digits);
    }

    private static String convertToDigit(String str) {
        String[] strNumbers = str.split(" ");
        String digits = "";

        for (int i = 0; i < strNumbers.length; i++) {
            String currentNum = strNumbers[i];
            int numCount = getNumCount(currentNum);
            if (numCount == 1) {
                digits += getDigit(currentNum);
            } else if (numCount == 2) {
                String digit = getDigit(strNumbers[i+1]);
                digits = digits.concat(digit).concat(digit);
                i++;
            } else if (numCount == 3) {
                String digit = getDigit(strNumbers[i+1]);
                digits = digits.concat(digit).concat(digit).concat(digit);
                i++;
            }
        }

        return digits;
    }

    //one three double five nine ...

    private static int getNumCount(String value) {
        if ("double".equalsIgnoreCase(value)) {
            return 2;
        } else if ("triple".equalsIgnoreCase(value)) {
            return 3;
        }
        return 1;
    }


    private static String getDigit(String strNumber) {
        if ("one".equalsIgnoreCase(strNumber)) {
            return "1";
        } else if ("two".equalsIgnoreCase(strNumber)) {
            return "2";
        } else if ("three".equalsIgnoreCase(strNumber)) {
            return "3";
        } else if ("four".equalsIgnoreCase(strNumber)) {
            return "4";
        } else if ("five".equalsIgnoreCase(strNumber)) {
            return "5";
        } else if ("six".equalsIgnoreCase(strNumber)) {
            return "6";
        } else if ("seven".equalsIgnoreCase(strNumber)) {
            return "7";
        } else if ("eight".equalsIgnoreCase(strNumber)) {
            return "8";
        } else if ("nine".equalsIgnoreCase(strNumber)) {
            return "9";
        } else if ("zero".equalsIgnoreCase(strNumber)) {
            return "0";
        }
        return "-";
    }

}


