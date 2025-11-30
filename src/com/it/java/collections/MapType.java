package com.it.java.collections;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MapType {

    public static void main(String[] args) throws Exception {

        testWeakHashMap();

        identityHashMap();

//        testWeakHashMap2();


    }

    /*
    👉 If a key is no longer referenced anywhere else in your program,
    👉 the Garbage Collector (GC) will automatically remove that entry from the map.
     */
    private static void testWeakHashMap() throws Exception {

        String one = new String("OneKey");
        String two = new String("TwoKey");
        String three = new String("ThreeKey");
        String nonObjectKey = "non-ObjectKey";
        Object keyAndValue = new Object();

        WeakHashMap<Object, Object> map = new WeakHashMap<>();
        map.put(one, "One");
        map.put(two, "two");
        map.put(three, three);
        map.put(null, null);
        map.put(nonObjectKey, "non-ObjectVal");
        map.put(new String("direct"), new String("direct"));
        map.put(keyAndValue, keyAndValue);


        System.out.println(map);
        two = null;
        three = null;
        nonObjectKey = null; //This is a String literal, stored in the String pool. Interned strings are strongly referenced by JVM.

        keyAndValue = null;

        System.gc();
        Thread.sleep(1000);
        System.out.println("After GC");
        System.out.println(map);
        System.out.println("--------------------");

    }

    /*
   It compares keys using == (reference equality) → NOT using .equals()
   So two different objects with the same content are treated as different keys.
    */
    private static void identityHashMap() {

        Map<String, String> map = new IdentityHashMap<>();

        String a1 = new String("hello");
        String a2 = new String("hello");

        map.put(a1, "value1");
        map.put(a2, "value2");

        System.out.println(map);
        System.out.println("Size: " + map.size());
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



}
