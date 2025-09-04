package Decorator.example;

public class Burger implements FoodItem{
    @Override
    public String description() {
        return "Burger";
    }

    @Override
    public double getPrice() {
        return 40.0;
    }
}
