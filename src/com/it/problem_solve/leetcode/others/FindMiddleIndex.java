package com.it.problem_solve.leetcode.others;

/*
A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ..
... + nums[nums.length-1].
 */
public class FindMiddleIndex {

    public static void main(String[] args) {

        int[] arr = {1,-1,4};

        System.out.println(findMiddleIndex(arr));
    }

    private static int findMiddleIndex(int[] arr){
        int totalSum=0;
        int len = arr.length;
        for(int i=0;i<len;i++){
            totalSum += arr[i];
        }
        int rightSum = totalSum;
        int leftSum = 0;

        for(int i=0;i<len;i++){
            rightSum -= arr[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }


}
