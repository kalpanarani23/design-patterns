package Decorator.example;

public class Pizza implements FoodItem{
    @Override
    public String description() {
        return "PIZZA";
    }

    @Override
    public double getPrice() {
        return 70.5;
    }
}
