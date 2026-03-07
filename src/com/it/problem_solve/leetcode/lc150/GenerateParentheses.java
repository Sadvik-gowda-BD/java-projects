package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(solve(3));
    }

    //Output: ["((()))","(()())","(())()","()(())","()()()"]
    public static List<String> solve(int n) {
        List<String> ls = new ArrayList<>();
        rec(0, 0, new StringBuilder(), ls, n);
        return ls;
    }

    public static void rec(int open, int close, StringBuilder sb, List<String> ans, int n) {
        if (open == n && close == n) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            open++;
            rec(open, close, sb, ans, n);
            open--;
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            close++;
            rec(open, close, sb, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    // ["((()))","(()())","(())()","()(())","()()()"]
    private static List<String> solve2(int n) {
        List<String> res = new ArrayList<>();
        solve2(n, res, 0, new StringBuilder());
        return res;
    }

    private static void solve2(int n, List<String> res, int close, StringBuilder sb) {
        if (n == 0 && close == 0) {
            res.add(sb.toString());
            return;
        }

        if (n > 0) {
            sb.append('(');
            solve2(n - 1, res, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close > 0) {
            sb.append(')');
            solve2(n, res, close - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
