package com.it.problem_solve.others;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberValue {

    public static void main(String[] args) {

        System.out.println("III " + getIntValue("III"));
        System.out.println("IV " + getIntValue("IV"));
        System.out.println("XII " + getIntValue("XII"));
        System.out.println("DCC " + getIntValue("DCC"));
        System.out.println("CM " + getIntValue("CM"));
        System.out.println("CMXX " + getIntValue("CMXX"));
        System.out.println("MC " + getIntValue("MC"));
        System.out.println("DCCLXXXIX " + getIntValue("DCCLXXXIX"));

    }

    // I, II, III, IV, V, VI, VII, VIII, IX, and X
    //VII IV
    private static int getIntValue(String romanNum) {
        int len = romanNum.length();
        int num = 0;

        for (int i = 0; i < len; i++) {
            int currentNum = getNum(romanNum.charAt(i));

            if (i < len - 1) {
                int nextNum = getNum(romanNum.charAt(i + 1));
                if (currentNum >= nextNum) {
                    num += currentNum;
                } else {
                    currentNum = nextNum - currentNum;
                    i++;
                    num += currentNum;
                }
                continue;
            }
            num += currentNum;
        }
        return num;
    }

    private static int getNum(char ch) {
        return switch (Character.toUpperCase(ch)) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }


    //Simple solution
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                res -= roman.get(s.charAt(i));
            } else {
                res += roman.get(s.charAt(i));
            }
        }

        return res + roman.get(s.charAt(s.length() - 1));
    }
}
