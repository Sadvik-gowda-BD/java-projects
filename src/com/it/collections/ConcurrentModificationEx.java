package com.it.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
ConcurrentModificationException throws when mod counter does not match.
When ever we modify the List in the middle of iteration the mod count will get increment,
and it doesn't match with the expected mod count.

To avoid we can use CopyOnWriteArrayList, ConcurrentHashMap
 */
public class ConcurrentModificationEx {
    public static void main(String[] args) {


        //checkSolutionCase();
        checkExceptionCase();

    }

    static void checkSolutionCase() {
        List<Integer> al = new CopyOnWriteArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        System.out.println("Before :" + al);
        for (int num : al) {
            System.out.println(num);
            if (num == 2) {
                al.add(7);

            }
        }
        System.out.println("After :" + al);

    }

    static void checkExceptionCase() {

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        // java.util.ConcurrentModificationException
        //        for (int i : al) {
        //            System.out.println(i);
        //            al.add(7);
        //        }


        //No error
        //        System.out.println("After :" + al);
        //        for (int i = 0; i < al.size(); i++) {
        //            System.out.println(al.get(i));
        //            if (al.get(i) == 2) {
        //                al.add(222);
        //            }
        //        }
        //        System.out.println("Before :" + al);


        // java.util.ConcurrentModificationException
        //        Iterator<Integer> it = al.iterator();
        //
        //        while (it.hasNext()) {
        //            if (it.next() == 2) {
        //                al.add(222);
        //            }
        //        }

        // No exception
        Iterator<Integer> it = al.iterator();
        System.out.println("Before :" + al);
        while (it.hasNext()) {
            if (it.next() == 2) {
                it.remove();
                //al.remove(2); This line throw concurrent exception
            }
        }
        System.out.println("After ::" + al);

    }

}