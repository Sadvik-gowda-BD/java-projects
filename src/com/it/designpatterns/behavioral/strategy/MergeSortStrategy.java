package com.it.designpatterns.behavioral.strategy;

public class MergeSortStrategy implements SortingStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Merge Sort");
    }
}
