package com.it.java.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Iterators {

    public static void main(String[] args) {
        //iteratorTest();
        //listIteratorTest();
        listIteratorReverseTraversalTest();
    }

    private static void listIteratorTest(){
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        ListIterator<Integer> lstItr = list.listIterator();
        while (lstItr.hasNext()) {
            int val = lstItr.next();
            if (val == 3) {
                System.out.print(val);
                //lstItr.remove(); //It removes the current element in Iterator, i.e 3
                //lstItr.add(303); //It add 303 after 3 at 3rd index
                lstItr.set(303);  //It replace the element 3 with 303
            } else {
                System.out.print(val);
            }
        }
        System.out.println("\nAfter remove 3 from list iterator :" + list);

    }

    private static void listIteratorReverseTraversalTest(){
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        ListIterator<Integer> lstItr = list.listIterator(5);
        while (lstItr.hasPrevious()) {
            int val = lstItr.previous();
            if (val == 3) {
                System.out.print(val);
                //lstItr.remove(); //It removes the current element in Iterator, i.e 3
                //lstItr.add(303); //It add 303 after 3 at 3rd index
                lstItr.set(303);  //It replace the element 3 with 303
            } else {
                System.out.print(val);
            }
        }
        System.out.println("\nAfter remove 3 from list iterator :" + list);

    }

    private static void iteratorTest() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        Iterator<Integer> lstItr = list.iterator();
        while (lstItr.hasNext()) {
            int val = lstItr.next();
            if (val == 3) {
                System.out.print(val);
                lstItr.remove(); //It removes the current element in Iterator, i.e 3
            } else {
                System.out.print(val);
            }
        }
        System.out.println("\nAfter remove 3 from list iterator :" + list);

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> setIterator = set.iterator();
        while (setIterator.hasNext()) {
            int val = setIterator.next();
            if (val == 3) {
                System.out.print(val);
                setIterator.remove(); //It removes the current element in Iterator, i.e 3
            } else {
                System.out.print(val);
            }
        }
        System.out.println("\nAfter remove 3 from set iterator :" + set);

    }
}
