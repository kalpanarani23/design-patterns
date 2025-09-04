package Decorator.example;

public class VegiesDecorator extends Decorator{
    public VegiesDecorator(FoodItem foodItem) {
        super(foodItem);
    }
    @Override
    public String description() {
        return foodItem.description() + "With veg";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + 15;
    }
}
