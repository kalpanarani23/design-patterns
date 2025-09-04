package StrategyPattern.example2;

import java.util.List;

public class MergeSort implements SortingStrategy{
    @Override
    public void sort(List<Integer> numbers) {
        System.out.println("Sorting number by merge sort");

    }
}
