package com.demo.others;

public class Altimetrik2 {

    public static void main(String[] args) {
        String str = "abcdabcxyabxy";
        System.out.println(getString(str));
    }

    private static String getString(String str) {

        if(str == null || str.isBlank()){
            throw new RuntimeException("String cannot be null or blank");
        }

        String longestString = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String left = str.substring(i, j + 1);
                String right = str.substring(j + 1, str.length());
                if (right.contains(left)) {
                    if (left.length() > longestString.length()) {
                        longestString = left;
                    }
                } else {
                    break;
                }
            }
        }
        return longestString;
    }


}
