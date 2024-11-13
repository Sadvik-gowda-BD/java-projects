package com.it.dsa.algorithms.recursion.problems;

import java.util.Stack;

public class ReverseStackByRec {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }

    private static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }
        int val = stack.pop();
        reverse(stack);
        insert(stack, val);
    }

    private static void insert(Stack<Integer> stack, int val) {

        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int num = stack.pop();
        insert(stack, val);
        stack.push(num);
    }
}
