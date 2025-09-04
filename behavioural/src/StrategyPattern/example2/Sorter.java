package StrategyPattern.example2;

import java.util.List;

//context
public class Sorter {
    SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(List<Integer> numbers) {
        sortingStrategy.sort(numbers);
    }
}
