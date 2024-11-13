package com.it.problem_solve.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*
761. Special Binary String

 */
public class LargestGoodBinaryString {

    public static void main(String[] args) {
        String binString = "11011000";
        System.out.println("Input: " + binString);
        String largestString = makeLargestSpecial(binString);
        System.out.println("Output: " + largestString);

    }


    public static String makeLargestSpecial(String S) {

        System.out.println("IP: " + S);

        if (S.isEmpty()) {
            return "";
        }

        int balance = 0, l = 0;
        List<String> subResults = new LinkedList<>();
        for (int r = 0; r < S.length(); r++) {
            if (S.charAt(r) == '0') {
                balance--;
            } else {
                balance++;
            }
            if (balance == 0) {
                subResults.add("1" + makeLargestSpecial(S.substring(l + 1, r)) + "0");
                l = r + 1;
            }
        }

        System.out.println(subResults);
        Collections.sort(subResults, Collections.reverseOrder());

        return String.join("", subResults);
    }

}
