package com.it.problem_solve.leetcode.lc150;

public class AddBinary {

    public static void main(String[] args) {

        System.out.println(solve("11", "1"));
        System.out.println(solve("1010", "1011"));

    }

    private static String solve(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aInd = a.length() - 1;
        int bInd = b.length() - 1;

        while (aInd >= 0 || bInd >= 0 || carry > 0) {
            int sum = carry;
            if (aInd >= 0) {
                sum += a.charAt(aInd) - '0';
                aInd--;
            }
            if (bInd >= 0) {
                sum += b.charAt(bInd) - '0';
                bInd--;
            }
            int rem = (sum % 2);
            carry = sum / 2;
            sb.append(rem);
        }

        return sb.reverse().toString();
    }


}
