package com.it.logic.leetcode;

public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(numDecodings("2010"));
    }

    /*
    dp[i] = dp[i-1] (if new ith digit is valid, like non zero) + dp[i-2] (if last two digits are valid)
     */
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // assume if string is empty
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1)
                dp[i] += dp[i - 1];

            if (twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
