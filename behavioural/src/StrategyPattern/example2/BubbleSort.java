package StrategyPattern.example2;

import java.util.List;

public class BubbleSort implements SortingStrategy{
    @Override
    public void sort(List<Integer> numbers) {
        System.out.println("Sorting number by bubble sort");

    }
}
