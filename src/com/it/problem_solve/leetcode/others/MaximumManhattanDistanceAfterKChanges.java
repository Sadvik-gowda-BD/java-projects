package com.it.problem_solve.leetcode.others;


import java.util.HashMap;
import java.util.Map;

//3443. Maximum Manhattan Distance After K Changes
public class MaximumManhattanDistanceAfterKChanges {

    public static void main(String[] args) {

        String s = "EWWE";
        int k = 0;

        String s2 = "NWSE";
        int k2 = 1;

//        System.out.println(solve(s, k));
        System.out.println(solve(s2, k2));
    }

    public static int solve(String s, int k) {
        int ans = 0;


        Map<Character, Integer> map = new HashMap<>();
        map.put('E', 0);
        map.put('W', 0);
        map.put('N', 0);
        map.put('S', 0);

        int len = 0;
        for (char ch : s.toCharArray()) {
            len++;
            map.put(ch, map.get(ch) + 1);
            int currMax = getMaxDist(map, len, k);
            ans = Math.max(ans, currMax);
        }

        return ans;
    }

    private static int getMaxDist(Map<Character, Integer> map, int len, int k) {

        int horizontal = Math.max(map.get('E'), map.get('W'));
        int vertical = Math.max(map.get('N'), map.get('S'));
        int remEle = len - horizontal - vertical;
        int maxEleCanChange = Math.min(k, remEle);

        int ans = horizontal + vertical + maxEleCanChange - (remEle - maxEleCanChange);

//        System.out.println(map + "  len:" + len + " ans:" + ans + " RE:" + remEle + " MEC:" + maxEleCanChange);

        return ans;
    }
}
