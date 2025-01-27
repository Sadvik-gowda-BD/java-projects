package com.it.problem_solve.leetcode.lc150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer, Integer> hm;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        }

        list.add(val);
        hm.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) {
            return false;
        }

        int index = hm.get(val);
        int lastEle = list.get(list.size() - 1);
        list.set(index, lastEle);
        hm.put(lastEle, index);
        list.remove(list.size() - 1);
        hm.remove(val);

        return true;

    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
