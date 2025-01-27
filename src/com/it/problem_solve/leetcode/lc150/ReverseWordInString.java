package com.it.problem_solve.leetcode.lc150;

import java.util.Arrays;

public class ReverseWordInString {

    public static void main(String[] args) {

        //System.out.println(solve("the sky is blue"));

        System.out.println(solve("  hello world  "));
    }

    //easy solution
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }

        return res.toString().trim();
    }

    public static String solve(String str) {

        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        int left = 0;
        int right = arr.length - 1;

        System.out.println(Arrays.toString(arr));

        while (left < right) {
            if (arr[left].isEmpty()) {
                left++;
                continue;
            } else if (arr[right].isEmpty()) {
                right--;
                continue;
            }
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        boolean firstChar = true;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].isEmpty()) {
                continue;
            }

            if (firstChar) {
                sb.append(arr[i]);
                firstChar = false;
            } else {
                sb.append(" ").append(arr[i]);
            }
        }
        return sb.toString();
    }
}
