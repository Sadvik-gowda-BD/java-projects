package com.it.java.copy;

public class DeepCopy implements Cloneable{

    public int[] arr;

    public DeepCopy(int[] arr){
        this.arr = arr;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCopy obj = (DeepCopy) super.clone();
        obj.arr =  obj.arr.clone();
        return obj;
    }
}
