package com.it.problem_solve.java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public static void main(String[] args) {
        String inputStr = "example string with duplicates";

        Map<Character, Long> duplicates = getDuplicates(inputStr);

        duplicates.forEach((character, count) ->
                System.out.println(character + ": " + count));
    }

    private static Map<Character, Long> getDuplicates(String inputStr) {

        return inputStr.chars() // Convert to IntStream
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(e -> e, Collectors.counting())) // Group by character and count. c-> c /Function.identity(),

                // Filter to retain only those characters that occur more than once
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }


}
