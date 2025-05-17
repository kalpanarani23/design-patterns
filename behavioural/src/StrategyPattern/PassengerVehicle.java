package StrategyPattern;


public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new Normal());
    }
}
