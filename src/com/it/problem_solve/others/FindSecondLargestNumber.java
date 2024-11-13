package com.it.problem_solve.others;

public class FindSecondLargestNumber {

    public static void main(String[] args) {
        int[] array = {4, 1, 7, 3, 9, 8, 5};

        System.out.println(byUsingForLoop(array));
    }

    private static int byUsingForLoop(int[] array) {
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        if (array.length < 2) {
            System.out.println("Array must have at least two elements.");
        } else {
            for (int num : array) {
                if (num > firstHighest) {
                    secondHighest = firstHighest;
                    firstHighest = num;
                } else if (num > secondHighest && num != firstHighest) {
                    secondHighest = num;
                }
            }
            if (secondHighest == Integer.MIN_VALUE) {
                System.out.println("No second highest element found.");
            } else {
                System.out.println("The second highest element is: " + secondHighest);
            }
        }

        return secondHighest;
    }




}
