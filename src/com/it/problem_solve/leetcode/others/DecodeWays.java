package com.it.problem_solve.leetcode.others;

public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(numDecodings("0211"));

        System.out.println(recursiveDecode("0211", 0));
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

    private static int recursiveDecode(String s, int index) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return 1; // This is a valid decoding
        }

        // Check for leading zero
        if (s.charAt(index) == '0') {
            return 0; // This decoding is invalid
        }

        // Decode single digit
        int ways = recursiveDecode(s, index + 1);

        // Decode two digits if possible
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += recursiveDecode(s, index + 2);
        }

        return ways;
    }


    //Memoization
    private int topDownDecode(String s, int index, int[] memo) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return 1; // This is a valid decoding
        }

        // Check memoization table
        if (memo[index] != -1) {
            return memo[index];
        }

        // Check for leading zero
        if (s.charAt(index) == '0') {
            return 0; // This decoding is invalid
        }

        // Decode single digit
        int ways = topDownDecode(s, index + 1, memo);

        // Decode two digits if possible
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += topDownDecode(s, index + 2, memo);
        }

        // Memoize the result
        memo[index] = ways;

        return ways;
    }
}
