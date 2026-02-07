package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterTilePossibilities {

    public static void main(String[] args) {

        String st = "AAB";

        char[] arr = st.toCharArray();
        Arrays.sort(arr);

        List<String> res = new ArrayList<>();
        solve(arr, new ArrayList<>(), new boolean[arr.length], res);
        System.out.println(res);

    }

    public static void solve(char[] arr, List<Character> currLs, boolean[] used, List<String> res) {

        if (!currLs.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (char ch : currLs) {
                sb.append(ch);
            }
            res.add(sb.toString());
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i-1])) continue;

            currLs.add(arr[i]);
            used[i] = true;
            solve(arr, currLs, used, res);
            used[i] = false;
            currLs.remove(currLs.size() - 1);
        }
    }


}
