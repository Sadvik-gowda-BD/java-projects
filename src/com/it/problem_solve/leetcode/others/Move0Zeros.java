package com.it.problem_solve.leetcode.others;

import java.util.Arrays;

public class Move0Zeros {

    public static void main(String[] args) {

        int[] arr = {9,0,2,20,0,5,0,1};
        met1(arr);

        char[] cArr = {'r','r','g','g','r','g','g','r','g','r','g','g'};
        solve(cArr);
    }

  /*
    Move all the zeroes to the end of the array with O(N) time complexity
    Input - [9,0,2,20,0,5,0,1 ]
    Output - [9,2,20,5,1,0,0,0]
            */
    private static void met1(int arr[]){
        int p1 = 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[p1];
                arr[p1] = temp;
                p1++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //{r,r,g,g,r,g,g,r,g,r,g,g} move r to right
    private static void solve(char[] arr){
        int pr=0;

       for(int i=0; i< arr.length;i++){
          if(arr[i] != 'r'){
              char temp = arr[pr];
              arr[pr] = arr[i];
              arr[i] = temp;
              pr++;
          }
       }
        System.out.println(Arrays.toString(arr));
    }

}
