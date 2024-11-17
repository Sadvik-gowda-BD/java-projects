package com.it.problem_solve.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
146. LRU Cache
 */
public class LRUCacheSoln2 {
    int size;

    HashMap<Integer, Integer> map;
    HashSet<Integer> set;


    public LRUCacheSoln2(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        this.set = new LinkedHashSet<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            updateSet(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
        updateSet(key);
        if (map.size() > size) {
            remove();
        }

    }

    private void updateSet(int key) {
        if (set.contains(key)) {
            set.remove(key);
            set.add(key);
        } else {
            set.add(key);
        }
    }

    private void remove() {
        Iterator<Integer> itr = set.iterator();
        int leastKey = itr.next();
        map.remove(leastKey);
        set.remove(leastKey);
    }

}
