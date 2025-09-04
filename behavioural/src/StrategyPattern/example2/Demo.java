package StrategyPattern.example2;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,4,3,9,4,5,0);

        Sorter sorter = new Sorter(new BubbleSort());
        sorter.sort(list);
    }
}
