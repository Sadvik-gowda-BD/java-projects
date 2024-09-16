package com.it.logic.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NthHighestElement {

    public static void main(String[] args) {

        List<Integer> elements = List.of(1,2,3,4,5);
        System.out.println(getNthHighestElement(elements));
    }

    private static int getNthHighestElement(List<Integer> elements){
        Optional<Integer> op = elements.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();
        return op.get();
    }
}
