package com.demo.others;

public class LT {

    public static void main(String[] args) {

        //1 5 3 7 9
        int[] arr = {13,1,9,10,13, 8, 5, 3, 7, 9};

        System.out.println(findSecondHeighest(arr));

    }

    private static int findSecondHeighest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentEle = arr[i];
            if (currentEle > first) {
                second = first;
                first = currentEle;
            }else if(currentEle>second && currentEle !=first){
                second = currentEle;
            }
        }
        return second;
    }

}
