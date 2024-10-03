package com.it.designpatterns.behavioral.strategy;

public class
SortingContextWithStrategy {

    private SortingStrategy sortingStrategy;

    public SortingContextWithStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        sortingStrategy.sort(array);
    }
}
