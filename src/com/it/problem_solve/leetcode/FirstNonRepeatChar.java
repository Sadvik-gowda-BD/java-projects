package com.it.problem_solve.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatChar {

    public static void main(String[] args) {

        System.out.println(find("kettle"));
        System.out.println(byUsingLinkedHashMap("kettle"));
    }

    public static char find(String st) {
        int[] arr = new int[256];

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            arr[ch] += 1;
        }

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (arr[ch] == 1) {
                return ch;
            }
        }
        return '0';
    }

    public static Character byUsingLinkedHashMap(String str) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        // Count frequencies of each character
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        Character firstNonRepeating = null;
        for (char c : str.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                firstNonRepeating = c;
                break;
            }
        }

        // Add the result to the list
        if (firstNonRepeating != null) {
            return firstNonRepeating;
        } else {
            return null;
        }


    }

}
