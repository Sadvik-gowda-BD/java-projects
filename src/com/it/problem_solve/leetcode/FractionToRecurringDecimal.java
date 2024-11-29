package com.it.problem_solve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public static void main(String[] args) {
        System.out.println((float) 4 / 333);

        //fractionToDecimal(4, 333);

        solve1(4, 333);

    }

    public static String solve1(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            ans.append("-");

        long num = (long) Math.abs((long) numerator);
        long den = (long) Math.abs((long) denominator);

        long quotient = num / den;
        long remainder = num % den;

        ans.append(String.valueOf(quotient));

        if (remainder == 0)
            return ans.toString();

        ans.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                ans.insert(pos, "(");
                ans.append(")");
                //return ans.toString();
                break;
            } else {
                //System.out.println(ans);
                map.put(remainder, ans.length());
                remainder *= 10;
                quotient = remainder / den;
                remainder %= den;
                ans.append(String.valueOf(quotient));
            }
        }

        System.out.println("Map: "+map);

        return ans.toString();
    }


public static String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
        return "0";
    }
    StringBuilder res = new StringBuilder();
    // "+" or "-"
    res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
    long num = Math.abs((long) numerator);
    long den = Math.abs((long) denominator);

    // integral part
    res.append(num / den);
    num %= den;
    if (num == 0) {
        return res.toString();
    }

    // fractional part
    res.append(".");
    HashMap<Long, Integer> map = new HashMap<Long, Integer>();
    map.put(num, res.length());
    while (num != 0) {
        num *= 10;
        res.append(num / den);
        num %= den;
        if (map.containsKey(num)) {
            int index = map.get(num);
            res.insert(index, "(");
            res.append(")");
            break;
        } else {
            map.put(num, res.length());
        }
    }
    System.out.println(res);
    System.out.println(map);
    return res.toString();
}
}
