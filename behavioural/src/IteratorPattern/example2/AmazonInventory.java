package IteratorPattern.example2;

public class AmazonInventory {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 30000.0);
        Product product2 = new Product("SmartPhone", 10000.0);
        Product product3 = new Product("Watch", 1000.0);

        Inventory inventory = new Inventory();
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        Iterator iterator = inventory.createIterator();
        Product currentProduct = iterator.first();

        while (currentProduct != null) {
            System.out.println("Product: " + currentProduct.getName() + ", Price: $" + currentProduct.getPrice());
            currentProduct = iterator.next();
        }

    }
}
