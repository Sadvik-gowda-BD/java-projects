package com.it.logic.others;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */
public class ReverseInteger {

    public static void main(String[] args) {



        System.out.println(reverse(-120));
        System.out.println(reverse(1534236469));

    }

    private static int reverse(int num){
        long reveseNum = 0;

        while (num != 0){
            int rem = num%10;
            reveseNum = (reveseNum*10)+rem;
            num = num/10;
        }

        int max = (int) Math.pow(2,31)-1;
        int min = -1 * (max + 1);

        System.out.println("Reversed string is:"+reveseNum);

        if( reveseNum > max){
            return 0;
        } else if (reveseNum < min) {
            return 0;
        }

        return (int) reveseNum;
    }

}
