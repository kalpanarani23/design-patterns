package Decorator;


public class Main {

    public static void main(String[] args) {
        // Create a plain pizza
        Pizza pizza = new PlainPizza();

        // Decorate the pizza with cheese and pepperoni
        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniPizzaDecorator(pizza);

        // Get the description and cost of the decorated pizza
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());
    }
}
