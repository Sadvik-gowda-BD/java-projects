package com.it.logic;

public class PalindromeAndReverseNumber {

    public static void main(String[] args) {
        int num = 1236321;
        int reversedNum = reversedNum(num);

        if(num == reversedNum){
            System.out.println("Given num is palindrome");
        }else {
            System.out.println("Given num is not palindrome");
        }
    }

    private static int reversedNum(int num) {
        int currentNum = num;
        int reversedNum = 0;

        while (currentNum > 0) {
            int remainder = currentNum % 10;
            currentNum = currentNum / 10;
            reversedNum = (reversedNum * 10) + remainder;
        }
        System.out.println("Reversed num is : "+reversedNum);
        return reversedNum;
    }
}
