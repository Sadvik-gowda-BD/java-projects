package com.it.dsa.algorithms.dp;

//213. House Robber II
public class HouseRobber2 {

    public static void main(String[] args) {

        int[] a1 = {2,3,2};
        int[] a2 = {1,2,3,1};
        int[] a3 = {1,2,3};

//        System.out.println(solve(a1));
//        System.out.println(solve(a2));
        System.out.println(solve(a3));
    }

    public static int solve(int[] arr) {

        int len = arr.length;

        if (len == 0) return 0;
        if(len == 1) return arr[0];
        if(len == 2) return  Math.max(arr[0], arr[1]);


        int[] dp = new int[len - 1];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < len - 1; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        int val1 = dp[dp.length - 1];

        if(len == 2) return val1;

        int[] dp2 = new int[len - 1];

        dp2[0] = arr[1];
        dp2[1] = Math.max(arr[1], arr[2]);
        for (int i = 3; i < len; i++) {
            int dpInd = i-1;
            dp2[dpInd] = Math.max(dp2[dpInd - 1], arr[i] + dp2[dpInd - 2]);
        }

        int val2 = dp2[dp2.length - 1];

        return Math.max(val1, val2);
    }
}
