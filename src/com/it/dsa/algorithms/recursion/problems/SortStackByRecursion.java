package com.it.dsa.algorithms.recursion.problems;

import java.util.Stack;

public class SortStackByRecursion {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(5);
        st.push(3);
        st.push(2);
        st.push(20);
        st.push(3);
        System.out.println("Before: " + st);
        sort(st);
        System.out.println("After: " + st);
    }

    private static void sort(Stack<Integer> st) {

        if (st.isEmpty()) return;

        Integer ele = st.pop();
        sort(st);
        place(st, ele);
    }

    private static void place(Stack<Integer> st, Integer num) {

        if (st.isEmpty()) {
            st.push(num);
            return;
        }

        int ele = st.peek();
        if (num < ele) {
            st.pop();
            place(st, num);
            st.push(ele);
        } else {
            st.push(num);
        }
    }
}
