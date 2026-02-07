package com.it.problem_solve.leetcode.others;


import java.util.HashSet;
import java.util.Set;

//1298. Maximum Candies You Can Get from Boxes
public class MaximumCandiesFromBoxes {


    public static void main(){

    }


    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {

        int ans = 0;
        int len = status.length;

        Set<Integer> keySet = new HashSet<>();
        Set<Integer> earnedBox = new HashSet<>();
        Set<Integer> used = new HashSet<>();

        for(int b: initialBoxes){
            earnedBox.add(b);
        }



        return ans;
    }


}
