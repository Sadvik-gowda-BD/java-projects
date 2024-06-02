package com.it.collections;

import java.util.ArrayList;

//Custom array list without duplicate elements
public class CustomArrayList<E> extends ArrayList<E> {

    @Override
    public boolean add(E o) {

        if (this.contains(o)) {
            return false;
        }
        return super.add(o);
    }

    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(1);
        customArrayList.add(2);
        customArrayList.add(3);
        customArrayList.add(2);
        customArrayList.add(2);
        customArrayList.add(4);
        System.out.println(customArrayList);
    }
}
