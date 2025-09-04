package Decorator.example;

public class CheeseDecorator extends Decorator{
    public CheeseDecorator(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public String description() {
        return foodItem.description() + "With Cheese";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + 10.0;
    }
}
