package StrategyPattern;


public class Special implements DriveStrategy {
    @Override
    public void drive() {
        System.out.printf("Special Capability");
    }
}
