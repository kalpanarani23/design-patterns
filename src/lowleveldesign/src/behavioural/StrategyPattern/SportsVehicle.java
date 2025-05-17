package lowleveldesign.src.behavioural.StrategyPattern;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new Special());
    }
}
