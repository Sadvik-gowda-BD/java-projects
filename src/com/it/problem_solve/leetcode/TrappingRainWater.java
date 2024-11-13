package com.it.problem_solve.leetcode;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2= {2,0,2,1};

        System.out.println(solve(arr2));
    }

    private static int solve(int[] height){

        int len = height.length;
        int left = 0;
        int leftMax = height[0];
        int right = len-1;
        int rightMax= height[len-1];
        int water= 0;

        while(left<right){

            if(leftMax<rightMax){
                left++;
                leftMax= Math.max(leftMax,height[left]);
                water += leftMax-height[left];
            }else {
                right--;
                rightMax= Math.max(rightMax,height[right]);
                water += rightMax-height[right];
            }

        }
        return water;

    }
}
