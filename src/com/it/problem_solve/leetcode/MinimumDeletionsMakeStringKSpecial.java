package com.it.problem_solve.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//3085. Minimum Deletions to Make String K-Special
public class MinimumDeletionsMakeStringKSpecial {


    public static void main(String[] args) {

//        System.out.println(solve("aabcaba", 0));
//        System.out.println(solve("dabdcbdcdcd", 2));
//        System.out.println(solve("aaabaaa", 2));
        System.out.println(solve("zzfzzzzppfp", 1));
        System.out.println(solve("vnnppvvbbn", 0));

    }

    public static int solve(String st, int k) {
        int ans = Integer.MAX_VALUE;

        HashMap<Character, Integer> charMap = new HashMap<>();

        for (Character ch : st.toCharArray()) {
            charMap.putIfAbsent(ch, 0);
            charMap.put(ch, charMap.get(ch) + 1);
        }


        int[] nums = charMap.values().stream().mapToInt(n -> n).toArray();
        Arrays.sort(nums);


        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int deleted = 0;
            for (int j = 0 ; j < len; j++) {
                if(nums[j]<nums[i]){
                    deleted+=nums[j];
                }else if ((nums[j] - nums[i]) > k) {
                    deleted += nums[j] - (nums[i] + k);
                }
            }
            ans = Math.min(ans, deleted);
        }
        return ans;
    }
}
