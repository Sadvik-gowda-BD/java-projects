package com.it.copy;

public class ShallowCopy implements Cloneable{

    public int[] arr;

    public ShallowCopy(int[] arr){
        this.arr = arr;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
