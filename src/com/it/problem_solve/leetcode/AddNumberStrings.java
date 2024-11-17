package com.it.problem_solve.leetcode;

/*
415. Add Strings
 */
public class AddNumberStrings {

    public static void main(String[] args) {

        System.out.println(solve("121", "191"));
        easySolution("", "");
    }

    public static String easySolution(String num1, String num2) {
        StringBuilder str = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1, carry = 0, sum;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            sum = digit1 + digit2 + carry;
            str.append(sum % 10);
            carry = sum / 10;
        }

        return str.reverse().toString();
    }

    private static String solve(String num1, String num2) {

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;

        String res = "";
        while (p1 >= 0 && p2 >= 0) {

            int n1 = Character.getNumericValue(num1.charAt(p1));
            int n2 = num2.charAt(p2) - '0';

            int r = n1 + n2 + carry;
            int rem = r % 10;

            res = rem + res;
            carry = r / 10;

            p1--;
            p2--;
        }

        while (p1 >= 0) {
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(p1)));
            int r = n1 + carry;
            int rem = r % 10;

            res = rem + res;
            carry = r / 10;

            p1--;
        }

        while (p2 >= 0) {
            int n2 = Integer.parseInt(String.valueOf(num2.charAt(p2)));
            int r = n2 + carry;
            int rem = r % 10;

            res = rem + res;
            carry = r / 10;

            p2--;
        }

        if (carry > 0) {
            res = carry + res;
        }

        return res;
    }
}
