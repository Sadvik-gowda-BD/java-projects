package com.it.logic.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubStringPalindrom {

    public static void main(String[] args) {
        String st = "aaa";
        System.out.println(solve(st));
    }


    //TODO: check to optimize
    static List<String> solve(String st) {

        List<String> plList = new ArrayList<>();
        for (int i = 0; i < st.length(); i++) {
            for (int j = i; j < st.length(); j++) {
                String newSt = st.substring(i, j + 1);
                if (isPalindrom(newSt)) {
                    plList.add(newSt);
                }
            }
        }

        return plList;
    }

    static boolean isPalindrom(String st) {
        if (st.length() == 1) {
            return true;
        }
        String reverse = new StringBuilder(st).reverse().toString();
        return st.equals(reverse);
    }
}
