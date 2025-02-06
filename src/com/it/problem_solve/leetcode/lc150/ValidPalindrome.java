package com.it.problem_solve.leetcode.lc150;

public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(optmize("A man, a plan, a canal: Panama"));
        System.out.println(optmize("race a car"));
    }

    private static boolean optmize(String st) {
        int left = 0;
        int right = st.length() - 1;

        while (left < right) {
            char leftChar = st.charAt(left);
            if (!(Character.isAlphabetic(leftChar) || Character.isDigit(leftChar))) {
                left++;
                continue;
            }

            char rightChar = st.charAt(right);
            if (!(Character.isAlphabetic(rightChar) || Character.isDigit(rightChar))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(st.charAt(left)) != Character.toLowerCase(st.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean solve(String st) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        String validStr = sb.toString();
        int left = 0;
        int right = validStr.length() - 1;

        while (left < right) {
            if (validStr.charAt(left) != validStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
