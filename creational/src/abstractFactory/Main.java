package abstractFactory;

import abstractFactory.furnitureExample.*;

public class Main {
    public static void main(String[] args) {
        createFurniture(new ModernFurnitureFactory());
        createFurniture(new VintageFurnitureFactory());
    }

    public static void createFurniture(FurnitureFactory factory) {
        Chair chair = factory.createChair();
        Table table = factory.createTable();

        chair.sit();
        table.eat();
    }
}
