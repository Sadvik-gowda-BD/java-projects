package com.demo.others;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lt2 {

    public static void main(String[] args) {
        printCharOccurrence("abcadbas");
    }

    private static void printCharOccurrence(String input) {

        input.chars().forEach(e-> System.out.println(e));


        Map<Character, Long> result = input.chars().mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);


    }
}
