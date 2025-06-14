package com.it.problem_solve.leetcode;


//2566. Maximum Difference by Remapping a Digit
public class MaximumDifferenceRemappingDigit {

    public static void main(String[] args) {

        System.out.println(solve(11891));
        System.out.println(90);
    }

    public static int solve(int num) {

        return maxNum(num) - minNum(num);
    }

    public static int maxNum(int num) {
        String st = String.valueOf(num);
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch != '9') {
                st = st.replace(ch, '9');
                break;
            }
        }
        return Integer.parseInt(st);
    }

    public static int minNum(int num) {
        String st = String.valueOf(num);
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch != '0') {
                st = st.replace(ch, '0');
                break;
            }
        }
        return Integer.parseInt(st);
    }
}
