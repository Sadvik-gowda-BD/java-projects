package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test2 {

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


}
