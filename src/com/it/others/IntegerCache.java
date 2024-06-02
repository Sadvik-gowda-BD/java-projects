package com.it.others;

public class IntegerCache {

    /*
    Java keeps an integer cache of integer instances in range of -128 to 127, like integer pool.
    Cache is applicable for Integer=18 and Integer.valueOf(18).

    java.lang.Long has a cache for long between -128 to +127.
     */

    public static void main(String[] args) {

        Integer num1 = 117;
        Integer num2 = 117;
        System.out.println("num1 == num2 :" + (num1 == num2)); //true, both have same reference as value is between 128 - 128

        Integer num3 = 700;
        Integer num4 = 700;
        System.out.println("num3 == num4 :" + (num3 == num4)); //false, both pointing to different memory location

        System.out.println("num3.equals(num4) :" + (num3.equals(num4))); //checking the value and not reference

        Integer num5 = Integer.valueOf(5);
        Integer num6 = Integer.valueOf(5);
        System.out.println("num5==num6 :" + (num5 == num6));

        Integer num7 = 5;
        Integer num8 = new Integer(5);
        System.out.println("num7==num8 :" + (num7 == num8));


    }
}
