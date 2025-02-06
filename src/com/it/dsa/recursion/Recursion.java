package com.it.dsa.recursion;

import java.util.Stack;

public class Recursion {

    public static void main(String[] args) {

        String st = "abcd";
        System.out.println(reverseString1(st, st.length() - 1));
        System.out.println(reverseString2(st, 0));
        System.out.println(reverseString3(st, "", 0));

    }

    private static String reverseString1(String st, int ind) {
        if (ind < 0) {
            return "";
        }
        return st.charAt(ind) + reverseString1(st, ind - 1);
    }

    private static String reverseString2(String st, int ind) {

        if (ind >= st.length()) {
            return "";
        }
        return reverseString2(st, ind + 1) + st.charAt(ind);
    }

    private static String reverseString3(String st, String ans, int ind) {
        if (ind >= st.length()) {
            return ans;
        }
        return reverseString3(st, st.charAt(ind) + ans, ind + 1);
    }


    private static void removeEleFromStk(Stack<Integer> st, int n) {

        int val = st.pop();
        if (n == 0) {
            return;
        }
        removeEleFromStk(st, n - 1);
        st.push(val);
    }
}
