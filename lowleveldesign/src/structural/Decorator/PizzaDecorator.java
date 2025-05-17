package lowleveldesign.src.structural.Decorator;

public abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }

}
