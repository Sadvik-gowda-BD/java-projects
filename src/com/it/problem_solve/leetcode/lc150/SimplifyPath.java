package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;
import java.util.Stack;

/*
71. Simplify Path
 */
public class SimplifyPath {

    public static void main(String[] args) {

        String s1 = "/home/";

        String s4 = "/.../abc/../b///c/../d/./";


        String[] sa = "/../".split("/");
        System.out.println(Arrays.toString(sa));
        System.out.println(solve("/../"));


    }

    public static String solve(String st) {

        String[] arr = st.split("/");

        Stack<String> stack = new Stack<>();
        for (String ele : arr) {
            if (ele.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (ele.isEmpty() || ele.equals(".")) {
                continue;
            } else {
                stack.push(ele);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (String ele : stack) {
            sb.append("/");
            sb.append(ele);
        }

        if(sb.isEmpty()){
            return "/";
        }

        return sb.toString();
    }


}
