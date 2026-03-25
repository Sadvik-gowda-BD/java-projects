package com.it.java.others;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

// Declare class as final to prevent subclassing
public final class ImmutablePerson {

    // All fields are private and final
    private final String name;
    private final int age;
    private final List<String> hobbies; // Mutable type — needs special handling

    // Constructor initializes all fields
    public ImmutablePerson(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        // Defensive copy to prevent external mutation
        this.hobbies = new ArrayList<>(hobbies);
    }

    // Only getters — no setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        // Return unmodifiable view to prevent mutation
        return Collections.unmodifiableList(hobbies);
    }

    @Override
    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + ", hobbies=" + hobbies + "}";
    }

    public static void main(String[] args) {
        List<String> hobbies = new ArrayList<>(List.of("Reading", "Cycling"));
        ImmutablePerson person = new ImmutablePerson("Alice", 30, hobbies);

        System.out.println(person);

        // Modifying original list doesn't affect the object
        hobbies.add("Gaming");
        System.out.println("After modifying original list: " + person);

        // This throws UnsupportedOperationException — list is unmodifiable
        // person.getHobbies().add("Swimming");
    }
}

/*
1. Thread Safety (No lock/Synchronization Needed)
2. Safe Sharing of Data
3. Avoiding Side Effects (Predictable Code)
4. Caching & Hash-based Collections
5. Security / Defensive Programming

 */
