package com.it.problem_solve.leetcode;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//227. Basic Calculator II
public class BasicCalculatorII {

    public static void main(String[] args) {

        String s1 = "3/2";
        System.out.println(solve(s1));

        String s2 = "1-1+1";
        System.out.println(solve(s2));
    }

    public static int solve(String st) {
        int len = st.length();

        Deque<String> q1 = new LinkedList<>();
        Deque<String> q2 = new LinkedList<>();

        int ind = 0;

        while (ind < st.length()) {

            char ch = st.charAt(ind);
            if (ch == ' ') {
                ind++;
                continue;
            }

            if (Character.isDigit(ch)) {
                String currSt = "";
                while (ind < len && Character.isDigit(st.charAt(ind))) {
                    currSt += st.charAt(ind);
                    ind++;
                }
                q1.addLast(currSt);
            } else {
                q1.addLast(String.valueOf(ch));
                ind++;
            }
        }


        System.out.println("Before: " + "q1:" + q1 + " q2:" + q2);

        doOp(q1, q2, "/");
        doOp(q2, q1, "*");
        doOp(q1, q2, "+");
        System.out.println("q1:" + q1 + " q2:" + q2);
        doOp(q2, q1, "-");


        return Integer.parseInt(q1.pop());
    }

    public static void doOp(Deque<String> q1, Deque<String> q2, String op) {

        q2.add(q1.pollFirst());

        while (!q1.isEmpty()) {
            String currStr = q1.pollFirst();
            if ("/".equals(op) && "/".equals(currStr)) {
                int n1 = Integer.parseInt(q1.pollFirst());
                int n2 = Integer.parseInt(q2.pollLast());
                int val = n2 / n1;
                q2.addLast(String.valueOf(val));
            } else if ("*".equals(op) && "*".equals(currStr)) {
                int n1 = Integer.parseInt(q1.pollFirst());
                int n2 = Integer.parseInt(q2.pollLast());
                int val = n1 * n2;
                q2.addLast(String.valueOf(val));
            } else if ("+".equals(op) && "+".equals(currStr)) {
                int n1 = Integer.parseInt(q1.pollFirst());
                int n2 = Integer.parseInt(q2.pollLast());
                int val = n1 + n2;
                q2.addLast(String.valueOf(val));
            } else if ("-".equals(op) && "-".equals(currStr)) {
                int n1 = Integer.parseInt(q1.pollFirst());
                int n2 = Integer.parseInt(q2.pollLast());
                int val = n2 - n1;
                q2.addLast(String.valueOf(val));
            } else {
                q2.addLast(String.valueOf(currStr));
            }

        }

    }


}
