package com.it.problem_solve.leetcode.others;

public class MaximumDifferenceRemappingDigit2 {

    public static void main(String[] args) {

        System.out.println(solve(1101057));
//        System.out.println(solve(8));
    }

    public static int solve(int num) {
        int max = getMax(num);
        int min = getMin(num);
        System.out.println("Max: " + max + " Min: " + min);
        return max - min;
    }

    private static int getMax(int num) {
        String st = String.valueOf(num);

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch != '9') {
                st = st.replace(ch, '9');
                break;
            }
        }
        return Integer.valueOf(st);
    }

    private static int getMin(int num) {
        String st = String.valueOf(num);
        char firstChar = st.charAt(0);
        Character secondChar = null;

        boolean same = true;

        for (int i = 1; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch != firstChar) {
                secondChar =ch;
                same = false;

                if (secondChar == '0') continue;
                break;
            }
        }

        if (same) {
            return Integer.valueOf(st.replace(firstChar, '1'));
        } else {
            if (firstChar == '1') {
                return Integer.valueOf(st.replace(secondChar, '0'));
            }
            return Integer.valueOf(st.replace(firstChar, '1'));
        }

    }


}
