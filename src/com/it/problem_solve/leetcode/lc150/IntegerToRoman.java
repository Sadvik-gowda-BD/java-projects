package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;
import java.util.HashMap;

/*
Input: num = 58

Output: "LVIII"

 */
public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(solve(10));
        System.out.println();

    }


    private static String solve(int num) {
        StringBuilder roman = new StringBuilder();
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        for (int i = 0; i < vals.length; i++) {

            if (num == 0) {
                break;
            }

            while (num >= vals[i]) {
                roman.append(strs[i]);
                num -= vals[i];
            }

        }
        return roman.toString();
    }

}
