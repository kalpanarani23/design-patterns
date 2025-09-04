package Decorator.example;


//After adding any toppings or decorating it still be that food item.
public abstract class Decorator implements FoodItem {
    protected FoodItem foodItem;

    public Decorator(FoodItem foodItem){
        this.foodItem = foodItem;
    }

}
