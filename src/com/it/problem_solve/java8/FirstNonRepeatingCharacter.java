package com.it.problem_solve.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String input = "swiss";

        // Convert the string into a stream of characters and count their occurrences

        Optional<Character> firstNonRepeating = getChar(input);

        // Print the result
        if (firstNonRepeating.isPresent()) {
            System.out.println("First non-repeating character: " + firstNonRepeating.get());
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    private static Optional<Character> getChar(String input) {

        Map<Character, Long> characterCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        // Find the first character with a count of 1
        return characterCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    private static Optional<Character> getChar2(String input) {

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, ++count);
            } else {
                map.put(ch, 1);
            }
        }

        Optional<Map.Entry<Character, Integer>> val = map.entrySet().stream().
                filter(e -> e.getValue() == 1)
                .findFirst();

        return val.map(Map.Entry::getKey);
    }


}
