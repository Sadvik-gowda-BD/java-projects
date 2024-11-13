package com.it.dsa.algorithms.recursion.problems;

import java.util.Stack;

public class RemoveNthElementFromStackByRec {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);
        remove(st, 2);
        System.out.println(st);
    }

    private static void remove(Stack<Integer> stack, int count) {

        if (count == 0) {
            return;
        }
        if (count == 1) {
            stack.pop();
            return;
        }
        int val = stack.pop();
        remove(stack, count - 1);
        stack.push(val);
    }
}
