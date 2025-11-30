package com.it.java.copy;

import java.util.Arrays;

public class DriverClass {

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1, 2,3,4,5};

        ShallowCopy shallowCopy = new ShallowCopy(arr);
        System.out.println("Shallow copy");
        System.out.println("Before:"+Arrays.toString(arr));

        ShallowCopy shallowCopy1 = (ShallowCopy)shallowCopy.clone();
        shallowCopy1.arr[0] = 99;
        System.out.println("After:"+Arrays.toString(arr));

        System.out.println("\n\n\n");


        int[] arr1 = {1, 2,3,4,5};
        DeepCopy deepCopy = new DeepCopy(arr1);
        System.out.println("Deep copy");
        System.out.println("Before:"+Arrays.toString(arr1));

        DeepCopy deepCopy1 = (DeepCopy)deepCopy.clone();
        deepCopy1.arr[0] = 99;
        System.out.println("After:"+Arrays.toString(arr1));

        //Clone not support
//        Normal n = new Normal();
//        n.clone;

    }
}
