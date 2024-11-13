package com.it.problem_solve.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOddAndEvenNum {

    public static void main(String[] args) {

        List<Integer> ls = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        Map<String, List<Integer>> result = ls.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));

        System.out.println(result);

        Map<String, Long> resultCount = ls.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd", Collectors.counting()));
        System.out.println(resultCount);

    }
}
