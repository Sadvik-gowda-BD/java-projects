package com.demo;

import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

public class Test1 {

    private static int ind = 0;


    public static void main(String[] args) throws Exception {

//        System.out.println(solve2("1 + 1"));
//        System.out.println(solve2("1+1+(2+2)-1"));

//        String st = "- (3 + (4 + 5))";
//        String st2 = removeSpace(st);

        System.out.println(solveByRecursion("(3-(5-(8)-(2+(9-(0-(8-(2))))-(4))-(4))")); //23

        System.out.println(solveByRecursion("3-(5-(8)-(2)))"));
//        System.out.println(solve("1-(     -2)"));

    }


    public int simpleSoln(String s) {
        int length = s.length();
        int sign = 1;
        int ans = 0;
        int currNo = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                currNo = s.charAt(i) - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    currNo = currNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                currNo = currNo * sign;
                ans += currNo;
                currNo = 0;
                sign = 1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                ans = prevSign * ans;
                int precAns = stack.pop();
                ans = precAns + ans;
            }
        }
        return ans;
    }

    public static int solveByRecursion(String st) {
        ind = 0;
        return solve2(st);
    }


    public static int solve2(String st) {
        int sum = 0;
        int len = st.length();

        for (int i = ind; i < len; i++) {
            char ch = st.charAt(i);
            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                int dig = getDigit(st, i);
                String digStr = String.valueOf(dig);
                sum += dig;
                if (dig < 0) {
                    i += digStr.length() - 2;
                } else {
                    i += digStr.length() - 1;
                }

            } else if (ch == '(') {
                ind = i + 1;
                int res = solve2(st);
                if (i > 0 && st.charAt(i - 1) == '-') {
                    res *= -1;
                }
                sum += res;
                i = ind;
            } else if (ch == ')') {
                ind = i;
                return sum;
            }
        }
        return sum;
    }

    private static int getDigit(String st, int start) {
        int val = 0;
        for (int j = start; j < st.length(); j++) {
            char ch2 = st.charAt(j);
            if (Character.isDigit(ch2)) {
                val *= 10;
                val +=  ch2-'0';
            } else {
                break;
            }
        }

        if (start > 0 && st.charAt(start - 1) == '-') {
            return val * -1;
        }
        return val;
    }

    private static String removeSpace(String st) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch != ' ') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
