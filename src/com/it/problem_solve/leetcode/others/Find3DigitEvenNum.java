package com.it.problem_solve.leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2094. Finding 3-Digit Even Numbers
public class Find3DigitEvenNum {

    public static void main(String[] args) {

        int[] arr = {2, 1, 3, 0};

        int[] res = solve(arr);
        System.out.println(Arrays.toString(res));
    }

    //Search on all answer.
    public static int[] solve(int[] digits) {

        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : digits) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> curr = new HashMap<>();
        for (int i = 100; i <= 999; i = i + 2) {
            int num = i;
            curr.clear();

            while (num > 0) {
                int dig = num % 10;
                curr.put(dig, curr.getOrDefault(dig, 0) + 1);
                num = num / 10;
            }

            boolean canMake = true;
            for (int key : curr.keySet()) {
                if (!map.containsKey(key) || !(map.get(key) >= curr.get(key))) {
                    canMake = false;
                    break;
                }
            }
            if (canMake) res.add(i);
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
