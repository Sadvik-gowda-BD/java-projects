package com.it.designpatterns.behavioral.strategy;

public class BubbleSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
    }
}
