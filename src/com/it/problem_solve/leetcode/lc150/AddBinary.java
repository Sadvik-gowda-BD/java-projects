package com.it.problem_solve.leetcode.lc150;

public class AddBinary {

    public static void main(String[] args) {

        System.out.println(solve("11", "1"));
        System.out.println(solve("1010", "1011"));

    }

    private static String solve(String s1, String s2) {

        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        byte carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i1 >= 0 || i2 >= 0) {

            if (i1 >= 0 && i2 >= 0) {
                int val = carry + Integer.parseInt(String.valueOf(s1.charAt(i1))) + Integer.parseInt(String.valueOf(s2.charAt(i2)));
                carry = setAndGetCarry(val, sb);
                i1--;
                i2--;
            } else if (i1 >= 0) {
                int val = carry + Integer.parseInt(String.valueOf(s1.charAt(i1)));
                carry = setAndGetCarry(val, sb);
                i1--;
            } else {
                int val = carry + Integer.parseInt(String.valueOf(s2.charAt(i2)));
                carry = setAndGetCarry(val, sb);
                i2--;
            }
        }

        if (carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }

    private static byte setAndGetCarry(int val, StringBuilder sb) {
        if (val == 0) {
            sb.insert(0, 0);
            return 0;
        } else if (val == 1) {
            sb.insert(0, 1);
            return 0;
        } else if (val == 2) {
            sb.insert(0, 0);
            return 1;
        } else {
            sb.insert(0, 1);
            return 1;
        }
    }

    public String simpleSolution(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1)
        {
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
