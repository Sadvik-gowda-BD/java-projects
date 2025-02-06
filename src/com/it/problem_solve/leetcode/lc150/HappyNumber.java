package com.it.problem_solve.leetcode.lc150;

import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {


        System.out.println(solve(19));
        System.out.println(2);
    }

    private static boolean solve(int num) {

        int n = num;
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int sum = 0;
            int temp = n;
            while (temp > 0) {
                int rem = temp % 10;
                temp = temp / 10;
                sum += (rem * rem);
            }

            if (sum == 1) {
                return true;
            }
            n = sum;
        }

        if(n==1){
            return true;
        }

        return false;
    }
}
