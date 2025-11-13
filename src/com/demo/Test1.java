package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

public class Test1 {

    private static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {

        System.out.println(solve("vzhofnpo"));
//        System.out.println(solve("bdda"));
    }


    //"vzhofnpo" -- f   vzh0
    //"fnohopzv" "fnopohzv"
    public static String solve(String s1) {

        StringBuilder sb = new StringBuilder();

        int ind = 0;
        Stack<Character> st = new Stack<>();

        while (ind < s1.length()) {
            char currCh = s1.charAt(ind);
            ind++;
            int minChar = hasMinCar(s1, ind);
            if (minChar == Integer.MAX_VALUE ) {
                st.add(currCh);
                continue;
            }else {
                if(!st.isEmpty() && st.peek() != minChar){
                    st.add(currCh);
                    continue;
                }
            }

            while (!st.isEmpty()) {
                char ch = st.peek();
                if (ch <= currCh) {
                    sb.append(st.pop());
                } else {
                    break;
                }
            }

            sb.append(currCh);
        }

        while (!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }

    private static int hasMinCar(String s, int ind) {
        char currCh = s.charAt(ind-1);

        for (int i = ind; i < s.length(); i++) {
            if (s.charAt(i) < currCh) {
                return s.charAt(i);
            }
        }
        return Integer.MAX_VALUE;
    }

}
