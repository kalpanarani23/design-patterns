package Decorator.example;

public class Main {

    public static void main(String[] args) {
        FoodItem pizza = new Pizza();
        FoodItem burger = new Burger();

        pizza = new ExtraToppings(new CheeseDecorator(new VegiesDecorator(pizza)), 20);

        System.out.println("pizza ----------" + pizza.description());
        System.out.println("pizza ----------" + pizza.getPrice());

    }
}
