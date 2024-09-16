package com.it.logic.leetcode;


import java.util.Arrays;

/*
1,2,3
4,5,6
6,1,2,3,4,5
5,6,1,2,3,4
 */
public class RotateArrayByKTimes {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(arr));
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        for(int i=0;i<k;i++){
            int n = (i+k+1)%(len);
            int temp=nums[i];
            nums[i]=nums[n];
            nums[n]=temp;
        }
    }
}
