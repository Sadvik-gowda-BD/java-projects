package com.it.problem_solve.leetcode;

//38. Count and Say
public class CountAndSay {

    public static void main(String[] args) {

        String res = solve(4);

        System.out.println(res);

    }

    public static String solveIt(int n) {

        if (n == 1) return "1";
        String res = "1";
        for (int j = 1; j < n; j++) {
            int size = res.length();

            String newStr = "";
            int count = 1;
            char preChar = res.charAt(0);
            for (int i = 1; i < size; i++) {
                char currChar = res.charAt(i);
                if (preChar == currChar) {
                    count++;
                } else {
                    newStr = newStr + count + preChar;
                    count = 1;
                    preChar = currChar;
                }
            }
            res = newStr + count + preChar;
        }

        return res;
    }

    public static String solve(int n) {
        if (n == 1) {
            return "1";
        }

        String res = solve(n - 1);
        StringBuilder newStr = new StringBuilder();

        int count = 1;
        char preChar = res.charAt(0);
        for (int i = 1; i < res.length(); i++) {
            char currChar = res.charAt(i);
            if (preChar == currChar) {
                count++;
            } else {
                newStr.append(count).append(preChar);
                count = 1;
                preChar = currChar;
            }
        }
        newStr.append(count).append(preChar);
        return newStr.toString();
    }


}
