package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Test1 {

    HashMap<Integer, Integer> hm = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    public static void main(String[] args) throws Exception {


    }


    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        }

        hm.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) {
            return false;
        }

        int index = hm.get(val);
        int lastEle = list.get(list.size()-1);
        list.set(index, lastEle);
        hm.put(lastEle, index);
        list.remove(list.size()-1);

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }


}
