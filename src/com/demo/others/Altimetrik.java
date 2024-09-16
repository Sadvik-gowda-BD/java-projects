package com.demo.others;

import java.util.Arrays;

public class Altimetrik {


    public static void main(String[] args) {

    }


    private static void test(){

        //0's are front and 1's at last
        int[] arr1 = {0,1,0,1,0,1};

        int p0 =0;
        for(int i=0;i< arr1.length;i++){
            if(arr1[i]==0){
                int temp = arr1[i];
                arr1[i] = arr1[p0];
                arr1[p0] = temp;
                p0++;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }

}
