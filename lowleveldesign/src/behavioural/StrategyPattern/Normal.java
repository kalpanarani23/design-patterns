package lowleveldesign.src.behavioural.StrategyPattern;

public class Normal implements DriveStrategy{
    @Override
    public void drive() {
        System.out.printf("Normal capability");
    }
}
