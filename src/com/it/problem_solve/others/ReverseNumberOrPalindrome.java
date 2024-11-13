package com.it.problem_solve.others;

public class ReverseNumberOrPalindrome {

    public static void main(String[] args) {

        int num = 1234;
        int reverseNum = reverseNum(num);

        System.out.println("Reverse num of " + num + " is :" + reverseNum);

        System.out.println("Givern num is palindrome :" + (reverseNum == num));

    }

    private static int reverseNum(int num) {
        int currentNum = num;
        int reverseNum = 0;

        while (currentNum > 0) {
            int remainder = currentNum % 10;
            reverseNum = (reverseNum * 10) + remainder;
            currentNum = currentNum / 10;
        }
        return reverseNum;
    }
}
