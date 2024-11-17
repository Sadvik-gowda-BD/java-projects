package com.it.problem_solve.others;

import java.util.ArrayList;
import java.util.List;

/*
Circular game
 */
public class JosephusProblem {

    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Step count

        int result = findJosephusPosition(n, k);
        int result2 = findJosephusPositionByList(n, k);
        System.out.println("The survivor's position is: " + result);
    }

    public static int findJosephusPosition(int n, int k) {
        int survivor = 0; // Base case for 1 person (0-indexed)

        for (int i = 1; i <= n; i++) {
            survivor = (survivor + k) % i;
        }

        return survivor + 1; // Convert to 1-indexed position
    }

    //use K-1 for 1 based index
    public static int findJosephusPositionByList(int n, int k) {
        List<Integer> people = new ArrayList<>();

        // Initialize the list with positions from 1 to n
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0; // Starting index

        // Eliminate people until only one is left
        while (people.size() > 1) {
            index = (index + k - 1) % people.size(); // Find the k-th person to eliminate
            people.remove(index); // Remove the person at the index
        }

        return people.get(0); // Return the last remaining person
    }

}
