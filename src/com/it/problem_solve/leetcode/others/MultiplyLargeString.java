package com.it.problem_solve.leetcode.others;

public class MultiplyLargeString {

    public static void main(String[] args) {

        System.out.println(multiply("123","456"));
    }

    private static String multiply(String s1, String s2){

        int m = s1.length();
        int n = s2.length();

        int[] products = new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int m1 = s1.charAt(i) - '0';
                int n1 = s2.charAt(j) - '0';
                int temp = m1*n1;
                products[i+j+1] += temp;
            }
        }

        int carry=0;
        for(int i=products.length-1; i>=0;i--){
            int temp = products[i] + carry;
            int rem = temp%10;
            carry = temp/10;
            products[i]= rem;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : products) {
            sb.append(num);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();

    }
}
