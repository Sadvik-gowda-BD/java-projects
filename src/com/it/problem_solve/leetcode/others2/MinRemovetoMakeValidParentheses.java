package com.it.problem_solve.leetcode.others2;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//1249. Minimum Remove to Make Valid Parentheses
public class MinRemovetoMakeValidParentheses {

    public static String solve(String str) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    set.add(i);
                } else {
                    st.pop();
                }
            }
        }

        while (!st.isEmpty()) {
            set.add(st.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(i)) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
