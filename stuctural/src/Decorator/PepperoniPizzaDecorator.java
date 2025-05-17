package Decorator;

public class PepperoniPizzaDecorator extends PizzaDecorator{
    public PepperoniPizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + " " + "Pepperoni";
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost() + 1.0;
    }
}
