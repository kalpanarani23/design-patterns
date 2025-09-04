package Decorator.example;

public class ExtraToppings extends Decorator{
    double extraToppings;

    public ExtraToppings(FoodItem foodItem, double extraToppings) {
        super(foodItem);
        this.extraToppings = extraToppings;
    }

    @Override
    public String description() {
        return foodItem.description() + "With extra toppings";
    }

    @Override
    public double getPrice() {
        return foodItem.getPrice() + extraToppings;
    }
}
