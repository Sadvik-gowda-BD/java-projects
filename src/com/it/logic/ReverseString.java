package com.it.logic;

public class ReverseString {

    public static void main(String[] args) {
        String str = "ABCD";
        System.out.println("Given string:" + str + " reversed string:" + reverseString(str));
    }

    private static String reverseString(String str) {
        //use string builder
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        return reversedString;
    }

}
