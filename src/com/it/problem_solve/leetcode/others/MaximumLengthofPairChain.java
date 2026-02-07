package com.it.problem_solve.leetcode.others;


import java.util.Arrays;

//646. Maximum Length of Pair Chain
public class MaximumLengthofPairChain {

    public static void main(String[] args) {

    }

    public int solveByGreedy(int[][] pairs){

        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int len = pairs.length;

        int[] pre = pairs[0];
        for (int i=1;i<len;i++){
            int[] curr = pairs[i];

            if(curr[0]>pre[1]){
                ans++;
                pre=curr;
            }
        }
        return ans;
    }

    public static int solveByRec(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[][] memo = new int[pairs.length][pairs.length];
        return solveByRec(pairs, 0, 1, memo);
    }

    public static int solveByRec(int[][] pairs, int pre, int curr, int[][] memo) {

        if (curr >= pairs.length) {
            return 1;
        }

        if (memo[pre][curr] != 0) {
            return memo[pre][curr];
        }

        int preEnd = pairs[pre][1];
        int currStart = pairs[curr][0];

        int pickChainCount;
        if (preEnd < currStart) {
            pickChainCount = 1 + solveByRec(pairs, curr, curr + 1, memo);
        } else {
            pickChainCount = solveByRec(pairs, pre, curr + 1, memo);
        }

        int notPickChainCount = solveByRec(pairs, curr, curr + 1, memo);

        int res = Math.max(pickChainCount, notPickChainCount);
        memo[pre][curr] = res;
        return res;
    }
}
