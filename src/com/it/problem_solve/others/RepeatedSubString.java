package com.it.problem_solve.others;

public class RepeatedSubString {

    public static void main(String[] args) {

        String st = "abcdabcdabcd";

        System.out.println(solve(st));
    }

    private static String solve(String st) {

        int strLen = st.length();
        String subStr = "";
        for (int i = 0; i < strLen / 2; i++) {
            subStr += st.charAt(i);

            if (strLen % subStr.length() == 0) {
                String newString = "";
                int n = strLen / subStr.length();

                while (n > 0) {
                    newString += subStr;
                    n--;
                }
                if (newString.equals(st)) {
                    return subStr;
                }
            }
        }

        return null;
    }
}
