package com.it.java.collections;

import java.util.WeakHashMap;

public class Map {

    public static void main(String[] args) throws Exception {

        testWeakHashMap();

        testWeakHashMap2();
    }

    private static void testWeakHashMap2() throws Exception {

        WeakHashMap<Object, Object> map = new WeakHashMap<>();
        Object keyAndValue = new Object();
        map.put(keyAndValue, keyAndValue);
        System.out.println("Before GC: " + map.size());
        keyAndValue = null;
        System.gc();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After GC: " + map.size()); // Should print 0 if GC collected the key
    }


    private static void testWeakHashMap() throws Exception {

        String one = new String("OneKey");
        String two = new String("TwoKey");
        String three = new String("ThreeKey");
        String nonObjectKey = "non-ObjectKey";
        String nonObjectVal = "non-ObjectVal";

        WeakHashMap<String, String> map = new WeakHashMap<>();
        map.put(one, "One");
        map.put(two, "two");
        map.put(three, three);
        map.put(null, null);
        map.put(nonObjectKey, nonObjectVal);
        map.put(new String("direct"), new String("direct"));

        System.out.println(map);
        two = null;
        three = null;
        nonObjectKey = null;

        System.gc();
        Thread.sleep(100);
        System.out.println("After GC");
        System.out.println(map);

    }
}
